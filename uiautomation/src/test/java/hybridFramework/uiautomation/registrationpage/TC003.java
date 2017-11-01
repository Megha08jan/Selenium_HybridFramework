package hybridFramework.uiautomation.registrationpage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hybridFramework.uiautomation.testbase.Testbase;
import hybridFramework.uiautomation.uiactions.Homepage;
import hybridFramework.uiautomation.uiactions.LoginPage;
import hybridFramework.uiautomation.uiactions.RegistrationPage;

public class TC003 extends Testbase {

	public static final Logger log = Logger.getLogger(TC003.class.getName());

	public Homepage homepage;
	public LoginPage loginpage;
	public RegistrationPage registrationpage;

	@BeforeClass
	public void init() throws Exception{

		setup();
	}

	@Test	
	public void registrationPage() throws Exception{
		try {
			log.info("in registration page");
			homepage = new Homepage();
			loginpage= homepage.clickonsignin();
			registrationpage= loginpage.clickoncreateaccount();
			registrationpage.registrationdetails();
			Assert.assertTrue(homepage.msgdisplay(), "Welcome to your account. Here you can manage all of your personal information and orders.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false, "not displayed");
			e.printStackTrace();
		}

	}

}
