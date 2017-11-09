package hybridFramework.uiautomation.registrationpage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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

	@DataProvider(name="registrationdetails")
	public String[][] loaddata() throws IOException{
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\uiautomation\\data\\Testdata1.xlsx";
		String sheetname = "RegistrationDetails";
		String[][] dataset = getdata(path, sheetname);
		return dataset;

	}


	@Test(dataProvider = "registrationdetails")	
	public void registrationPage(String emailid,String Firstname, String Lastname, String password, String selectday,String selectmont,String selectyear, String addressfirstname, String addresslastname,String address1, String city, String selectstate, String zipcode, String mobileno, String addressref) throws Exception{
		try {
			log.info("in registration page");
			homepage = new Homepage(driver);
			loginpage= homepage.clickonsignin();
			registrationpage= loginpage.clickoncreateaccount(emailid);
			registrationpage.registrationdetails(Firstname,Lastname,password,selectday,selectmont,selectyear,addressfirstname,addresslastname,address1,city,selectstate,zipcode,mobileno,addressref);
			Assert.assertEquals(homepage.verifydisplayedtext(), "Welcome to your account. Here you can manage all of your personal information and orders.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false, "not displayed");
			e.printStackTrace();
		}

	}

}
