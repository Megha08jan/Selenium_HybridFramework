package hybridFramework.uiautomation.loginpage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hybridFramework.uiautomation.testbase.Testbase;
import hybridFramework.uiautomation.uiactions.Homepage;
import hybridFramework.uiautomation.uiactions.LoginPage;
import hybridFramework.uiautomation.uiactions.RegistrationPage;

public class TC001 extends Testbase{
	public static final Logger log = Logger.getLogger(TC001.class.getName());

	public Homepage homepage;
	public LoginPage loginpage;
	public RegistrationPage registrationPage;

	@BeforeClass
	public void init() throws Exception{

		setup();
	}

	@DataProvider(name = "Logindetails")

	public Object[][] loaddatafromexcel() throws IOException{
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\uiautomation\\data\\Testdata1.xlsx";
		String sheetname= "LoginDetails";
		Object[][] data = getdata(path, sheetname);
		log.info(data);
		return data;

	}

	@Test(dataProvider="Logindetails")
	public void logintosite(String emailid, String pwd,String runmode) throws Exception{
		if(runmode.equalsIgnoreCase("n")){
		throw new SkipException("mark it as no run");
		}
		try {
			homepage = new Homepage(driver);
			loginpage = homepage.clickonsignin();	
			loginpage.logintowebsite(emailid, pwd);
			Thread.sleep(200);
		//Assert.assertTrue(homepage.msgdisplay(), "Welcome to your account. Here you can manage all of your personal information and orders.");
			
		Assert.assertEquals(homepage.verifydisplayedtext(), "Welcome to your account. Here you can manage all of your personal information and orders.");
			
			homepage.clickonsignout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false, "not displayed correct msg");
			e.printStackTrace();
		}

	}


}
