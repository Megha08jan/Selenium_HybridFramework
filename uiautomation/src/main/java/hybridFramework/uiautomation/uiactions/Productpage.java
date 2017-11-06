package hybridFramework.uiautomation.uiactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;

import hybridFramework.uiautomation.mouseactions.Mouseaction;
import hybridFramework.uiautomation.testbase.Testbase;

public class Productpage extends Testbase {

	public List<WebElement> list;
	public final static Logger log = Logger.getLogger(Productpage.class.getName());
	Mouseaction	mouseaction;


	public int getnoofproducts() throws Exception{
	mouseaction = new Mouseaction();	
		mouseaction.actionmovetoelementwithclick(getlocator("clickonwomen"));
		list = getlocators("listofproducts");
		log.info("total items are"+ " " + list.size());
		Thread.sleep(300);
		return list.size();

	}

	public void selectproduct(int productno) throws Exception{
		scrollwebpage(0, 1000);
		mouseaction.clickonwebelement(list.get(productno));
		scrollwebpage(0, 500);
		getlocator("clickonaddtocart").click();
		Thread.sleep(200);
		
	}

	List<String> windowlist = new ArrayList<String>();
	
	public void clickonlink() throws InterruptedException{
		scrollwebpage(0, 500);
		driver.findElement(By.xpath("//*[@onclick='socialsharing_facebook_click();']")).click();
		driver.findElement(By.xpath("//*[@class='btn btn-default btn-twitter']")).click();   


		java.util.Iterator<String> itr = windowhandles();

		while(itr.hasNext()){

			windowlist.add(itr.next());

		}

		Thread.sleep(600);
		driver.switchTo().window(windowlist.get(2));
		log.info(driver.findElement(By.xpath("//*[@class='fb_content clearfix']")).getText());
		driver.switchTo().window(windowlist.get(1));
		log.info(driver.findElement(By.xpath("//*[@id='status']")).getText());
		driver.quit();




	}


}
