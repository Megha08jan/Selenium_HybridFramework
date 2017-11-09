package hybridFramework.uiautomation.testbase;

import hybridFramework.uiautomation.excelreader.ExcelRead;
import hybridFramework.uiautomation.mouseactions.Mouseaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Testbase {

	public static final Logger log = Logger.getLogger(Testbase.class.getName());
	public WebDriver driver;
	public static Properties loadinfo;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;
	File file;
	FileInputStream fileinputstream;
	ExcelRead excelread;
	Mouseaction mouseaction;


	public void setup() throws Exception{
		loadfiles();
		extent = new ExtentReports(System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\uiautomation\\reports\\test.html",false);
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


	public WebElement getlocator(WebDriver driver, String webelement) throws Exception{
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

	public List<WebElement> getlocators(WebDriver driver,String webelement) throws Exception{

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

	public void scrollwebpage(WebDriver driver,int x, int y){
		log.info("scrolling down the webpage");
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("scrollTo("+x+","+y+")"); 
	}

	public WebElement selectradios(WebDriver driver,String webelement, String value) throws Exception{

		List<WebElement> list = getlocators(driver,webelement);
		WebElement radio = null;
		for(int i =0; i<list.size();i++){

			if (list.get(i).getAttribute("value").equals(value));
			log.info("selection radio based on value"+value);
			radio = list.get(i);
		}

		return radio;

	}

	public void dropdownselection(WebDriver driver,String webelement, int index) throws Exception{

		Select dropdown = new Select(getlocator(driver,webelement));
		log.info("selection dropdown");
		dropdown.selectByIndex(index);


	}


	public String[][] getdata(String path, String sheetname) throws IOException{

		excelread = new ExcelRead();

		String[][] dataset = excelread.readdata(path,sheetname);	     

		return dataset;

	}

	public Iterator<String> windowhandles(WebDriver driver){

		Set<String> windows	= driver.getWindowHandles();

		java.util.Iterator<String> itr = windows.iterator();

		return itr;

	}

	public String capturescreenshot(String Filename) throws IOException{
		if(Filename == ""){
			Filename = "blank";
		}
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagelocation = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\src\\main\\java\\hybridFramework\\uiautomation\\screenshots\\";
		File destfile = new File(imagelocation+Filename+"_"+formater.format(calender.getTime()));
		FileUtils.copyFile(srcfile, destfile);
		return destfile.toString();
	}

	public void getresult(ITestResult result) throws IOException{

		if(result.getStatus()==ITestResult.SUCCESS){

			test.log(LogStatus.PASS,result.getName()+ "test is pass",test.addScreenCapture(capturescreenshot("")));

		}
		else if(result.getStatus()==ITestResult.SKIP){

			test.log(LogStatus.SKIP,result.getName()+ "test is skipped and reason is"+result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.FAILURE){
			test.log(LogStatus.ERROR, result.getName()+"test is failed due to"+result.getThrowable());
			test.log(LogStatus.FAIL,test.addScreenCapture(capturescreenshot("")));
		}


	}
	@AfterMethod()
	public void aftermethod(ITestResult result) throws IOException{

		getresult(result);
	}

	@BeforeMethod()
	public void beformethod(Method result){
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName()+"test started");

	}

	@AfterClass()
	public void endtest(){
		closebrowser();
	}

	public void closebrowser(){

		driver.quit();
		log.info("browser is closed");
		extent.endTest(test);
		extent.flush();
	}
}









