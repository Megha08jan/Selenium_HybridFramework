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

	Mouseaction mouseaction;


	@BeforeClass
	public void init() throws Exception{

		setup();
	}



	public LoginPage clickonsignin() throws Exception{

		log.info("in homepage");
		getlocator("signin").click();
		return new LoginPage();
	}


	public void clickonsignout() throws Exception{

		getlocator("signout").click();

	}


	public Productpage womenproductselection() throws Exception{
		new Mouseaction().actionmovetoelementwithoutclick(getlocator("clickonwomen"));
		Thread.sleep(200);
		new Mouseaction().actionmovetoelementwithclick(getlocator("cliclontshirts"));

		return new Productpage();
	}

	public Productpage womenproducts() throws Exception{

		new Mouseaction().actionmovetoelementwithclick(getlocator("clickonwomen"));

		return new Productpage();
	}

	public boolean msgdisplay() throws Exception{

		return new AssertverifyBlock().assertelementdisplayed("msgdisplay");

	}

	public String verifydisplayedtext() throws Exception{

		return new AssertverifyBlock().verifytext("msgdisplay");

	}

}
