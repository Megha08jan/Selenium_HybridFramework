package hybridFramework.uiautomation.uiactions;

import hybridFramework.uiautomation.assertverfication.AssertverifyBlock;
import hybridFramework.uiautomation.dropdown.DropDownSelection;
import hybridFramework.uiautomation.testbase.Testbase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationPage extends Testbase {


	public static final Logger log = Logger.getLogger(RegistrationPage.class.getName());
	WebDriver driver;
	public AssertverifyBlock assertverifyblock;
	
	public RegistrationPage(WebDriver driver){
		this.driver=driver;
	}
	public void registrationdetails(String Firstname, String Lastname, String password, String selectday,String selectmont,String selectyear, String addressfirstname, String addresslastname,String address1, String city, String selectstate, String zipcode, String mobileno, String addressref ) throws Exception{

		try {
			DropDownSelection dropdown = new DropDownSelection(driver);
			selectradios(driver,"radiogender","2").click();;
			getlocator(driver,"customerfirstname").sendKeys(Firstname);
			getlocator(driver,"customerlastname").sendKeys(Lastname);
			getlocator(driver,"password").sendKeys(password);
			dropdown.dropdownselectionbyindex(driver,"selectday", selectday);
			dropdown.dropdownselectionbyindex(driver,"selectmonths", selectmont);
			dropdown.dropdownselectionbyindex(driver,"selectyear", selectyear);
			getlocator(driver,"addressfirstname").sendKeys(addressfirstname);
			getlocator(driver,"addressfirstname").sendKeys(addresslastname);
			getlocator(driver,"adress1").sendKeys(address1);
			getlocator(driver,"city").sendKeys(city);
			dropdown.dropdownselectionbyindex(driver,"selectstate", selectstate);
			getlocator(driver,"zipcode").sendKeys(zipcode);
			getlocator(driver,"mobileno").sendKeys(mobileno);
			getlocator(driver,"addressref").sendKeys(addressref);
			getlocator(driver,"register").click();

		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}





}
