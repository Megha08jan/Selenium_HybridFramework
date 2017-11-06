package hybridFramework.uiautomation.testbase;

import hybridFramework.uiautomation.excelreader.ExcelRead;
import hybridFramework.uiautomation.mouseactions.Mouseaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Testbase {

	public static final Logger log = Logger.getLogger(Testbase.class.getName());
	public static WebDriver driver;
	public static Properties loadinfo;
	File file;
	FileInputStream fileinputstream;
	ExcelRead excelread;
	Mouseaction mouseaction;

	public void setup() throws Exception{
		loadfiles();
		getbrowser((String) loadinfo.get("browser"));
		geturl((String) loadinfo.get("url"));

	}

	public void loadfiles() throws IOException{

		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\uiautomation\\configfiles\\log4j.properties");

		loadinfo = new Properties();
		file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\uiautomation\\configfiles\\setupinfo.properties");
		fileinputstream = new FileInputStream(file);

		loadinfo.load(fileinputstream);

		file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\uiautomation\\pageobject\\loginpage.properties");
		fileinputstream = new FileInputStream(file);

		loadinfo.load(fileinputstream);

		file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\uiautomation\\pageobject\\registrationpage.properties");
		fileinputstream = new FileInputStream(file);

		loadinfo.load(fileinputstream);

		file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\uiautomation\\pageobject\\homepage.properties");
		fileinputstream = new FileInputStream(file);

		loadinfo.load(fileinputstream);

		file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\uiautomation\\pageobject\\productpage.properties");
		fileinputstream = new FileInputStream(file);

		loadinfo.load(fileinputstream);



	}

	public void getbrowser(String browser){
		log.info("browser is loaded"+browser);

		if (browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\uiautomation\\driver\\chromedriver.exe");

			driver = new ChromeDriver();
		}
	}

	public void geturl(String url){
		log.info("url is loaded"+url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	public WebElement getlocator(String webelement) throws Exception{
		String element1 = (String) loadinfo.get(webelement);
		String[] elementvalues = element1.split(":");
		String locatortype = elementvalues[0];
		String locatorvalue = elementvalues[1];
		log.info("for element"+" " +element1+" "+"the locatortype is"+locatortype+" "+"the locator value is "+" "+locatorvalue);
		if (locatortype.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorvalue));
		else if(locatortype.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorvalue));
		else if(locatortype.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorvalue));
		else 
			throw new Exception("Unknown locator type '" + locatortype + "'");
	}

	public List<WebElement> getlocators(String webelement) throws Exception{

		String element1 = (String) loadinfo.get(webelement);
		String[] elementvalues = element1.split(":");
		String locatortype = elementvalues[0];
		String locatorvalue = elementvalues[1];
		log.info("for element"+" " +element1+" "+"the locatortype is"+locatortype+" "+"the locator value is "+" "+locatorvalue);
		if (locatortype.toLowerCase().equals("name"))
			return (List<WebElement>) driver.findElements(By.name(locatorvalue));
		else if (locatortype.toLowerCase().equals("xpath"))
			return (List<WebElement>) driver.findElements(By.xpath(locatorvalue));
		else 
			throw new Exception("Unknown locator type '" + locatortype + "'");

	}

	public void scrollwebpage(int x, int y){
		log.info("scrolling down the webpage");
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("scrollTo("+x+","+y+")"); 
	}

	public WebElement selectradios(String webelement, String value) throws Exception{

		List<WebElement> list = getlocators(webelement);
		WebElement radio = null;
		for(int i =0; i<list.size();i++){

			if (list.get(i).getAttribute("value").equals(value));
			log.info("selection radio based on value"+value);
			radio = list.get(i);
		}

		return radio;

	}

	public void dropdownselection(String webelement, int index) throws Exception{



		Select dropdown = new Select(getlocator(webelement));
		log.info("selection dropdown");
		dropdown.selectByIndex(index);


	}


	public String[][] getdata(String path, String sheetname) throws IOException{

		excelread = new ExcelRead();

		String[][] dataset = excelread.readdata(path,sheetname);	     

		return dataset;

	}

	public Iterator<String> windowhandles(){

		Set<String> windows	= driver.getWindowHandles();

		java.util.Iterator<String> itr = windows.iterator();
		
		return itr;

	}

}







