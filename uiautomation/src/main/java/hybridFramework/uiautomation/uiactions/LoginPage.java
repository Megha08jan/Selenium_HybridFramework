package hybridFramework.uiautomation.uiactions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import hybridFramework.uiautomation.assertverfication.AssertverifyBlock;
import hybridFramework.uiautomation.mouseactions.Mouseaction;
import hybridFramework.uiautomation.testbase.Testbase;

public class LoginPage extends Testbase {

	public static final Logger log = Logger.getLogger(LoginPage.class.getName());

Mouseaction mouseaction;
AssertverifyBlock assertverifyBlock;
	public RegistrationPage clickoncreateaccount() throws Exception{

		try {
			log.info("in loginpage");
			scrollwebpage(0,200);
			getlocator("emailcreate").sendKeys("megha@gmail.com");
			mouseaction = new Mouseaction();
			mouseaction.randomclick();
			Thread.sleep(1000);
			getlocator("createaccount").click();
			return new RegistrationPage();

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
		scrollwebpage(0,200);
		getlocator("emailaddress").sendKeys(emailid);
		getlocator("password").sendKeys(pwd);
		mouseaction = new Mouseaction();
		mouseaction.randomclick();
		Thread.sleep(1000);
		getlocator("clickonsignin").click();
		
		
	}
	
	
	

	}




