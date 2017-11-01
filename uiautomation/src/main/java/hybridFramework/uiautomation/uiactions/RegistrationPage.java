package hybridFramework.uiautomation.uiactions;

import hybridFramework.uiautomation.assertverfication.AssertverifyBlock;
import hybridFramework.uiautomation.testbase.Testbase;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class RegistrationPage extends Testbase {


	public static final Logger log = Logger.getLogger(RegistrationPage.class.getName());

	public AssertverifyBlock assertverifyblock;

	public void registrationdetails() throws Exception{

		try {
			selectradios("radiogender","2").click();;
			getlocator("customerfirstname").sendKeys("megha");
			getlocator("customerlastname").sendKeys("jain");
			getlocator("password").sendKeys("password");
			dropdownselection("selectday", 5);
			dropdownselection("selectmonths", 7);
			dropdownselection("selectyear", 6);
			getlocator("addressfirstname").sendKeys("suhant");
			getlocator("addressfirstname").sendKeys("jain");
			getlocator("adress1").sendKeys("amsterdam");
			getlocator("city").sendKeys("udaipur");
			dropdownselection("selectstate", 6);
			getlocator("zipcode").sendKeys("20345");
			getlocator("mobileno").sendKeys("0645072609");
			getlocator("addressref").sendKeys("rajasthan");
			getlocator("register").click();

		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}





}
