package hybridFramework.uiautomation.assertverfication;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import hybridFramework.uiautomation.testbase.Testbase;

public class AssertverifyBlock extends Testbase {

	public static final Logger log = Logger.getLogger(AssertverifyBlock.class.getName());

	WebDriver driver;
	public  AssertverifyBlock(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean assertelementdisplayed(String weblement) throws Exception{
		boolean isDisplayed = false;
		try {

			isDisplayed = getlocator(driver,weblement).isDisplayed(); 
			log.info("element is displayed"+getlocator(driver,weblement).getText());



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("element is not displayed");
			isDisplayed = false;

		}


		return isDisplayed;
	}


	public String verifytext(String webelement) throws Exception{

		String msgtext = getlocator(driver,webelement).getText();
		log.info("displayed msg is"+ msgtext);
		return msgtext;
	}



}
