package hybridFramework.uiautomation.uiactions;

import hybridFramework.uiautomation.assertverfication.AssertverifyBlock;
import hybridFramework.uiautomation.mouseactions.Mouseaction;
import hybridFramework.uiautomation.testbase.Testbase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homepage extends Testbase {


	public static final Logger log = Logger.getLogger(Homepage.class.getName());
	WebDriver driver;
	Mouseaction mouseaction;
	
	public Homepage(WebDriver driver){
		this.driver = driver;

	}

	public LoginPage clickonsignin() throws Exception{

		log.info("in homepage");
		getlocator(driver,"signin").click();
		return new LoginPage(driver);
	}


	public void clickonsignout() throws Exception{

		getlocator(driver,"signout").click();

	}


	public Productpage womenproductselection() throws Exception{
		new Mouseaction(driver).actionmovetoelementwithoutclick(getlocator(driver,"clickonwomen"));
		Thread.sleep(200);
		new Mouseaction(driver).actionmovetoelementwithclick(getlocator(driver,"cliclontshirts"));

		return new Productpage(driver);
	}

	public Productpage womenproducts() throws Exception{

		new Mouseaction(driver).actionmovetoelementwithclick(getlocator(driver,"clickonwomen"));

		return new Productpage(driver);
	}

	public boolean msgdisplay() throws Exception{

		return new AssertverifyBlock(driver).assertelementdisplayed("msgdisplay");

	}

	public String verifydisplayedtext() throws Exception{

		return new AssertverifyBlock(driver).verifytext("msgdisplay");

	}

}
