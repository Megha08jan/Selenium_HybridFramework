package hybridFramework.uiautomation.uiactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hybridFramework.uiautomation.assertverfication.AssertverifyBlock;
import hybridFramework.uiautomation.mouseactions.Mouseaction;
import hybridFramework.uiautomation.testbase.Testbase;

public class LoginPage extends Testbase {

	public static final Logger log = Logger.getLogger(LoginPage.class.getName());

	AssertverifyBlock assertverifyBlock;
	WebDriver driver;
	public LoginPage(WebDriver driver){

		this.driver = driver;
	}

	public RegistrationPage clickoncreateaccount(String emailid) throws Exception{

		try {
			log.info("in loginpage");
			scrollwebpage(driver,0,200);
			getlocator(driver,"emailcreate").sendKeys(emailid);
			new Mouseaction(driver).randomclick();
			Thread.sleep(1000);
			getlocator(driver,"createaccount").click();
			Assert.assertTrue(true);
			return new RegistrationPage(driver);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
			return null;	
		}



	}


	public void logintowebsite(String emailid, String pwd) throws Exception{
		log.info("in loginpage");
		log.info(emailid + " and "+ pwd);
		log.info("in loginpage");
		scrollwebpage(driver,0,200);
		getlocator(driver,"emailaddress").sendKeys(emailid);
		getlocator(driver,"password").sendKeys(pwd);
		new Mouseaction(driver).randomclick();
		Thread.sleep(1000);
		getlocator(driver,"clickonsignin").click();


	}




}




