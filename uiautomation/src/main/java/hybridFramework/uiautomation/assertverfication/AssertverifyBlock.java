package hybridFramework.uiautomation.assertverfication;


import org.apache.log4j.Logger;

import hybridFramework.uiautomation.testbase.Testbase;

public class AssertverifyBlock extends Testbase {

	public static final Logger log = Logger.getLogger(AssertverifyBlock.class.getName());

	public boolean assertelementdisplayed(String weblement) throws Exception{
		boolean isDisplayed = false;
		try {

			isDisplayed = getlocator(weblement).isDisplayed(); 
			log.info("element is displayed"+getlocator(weblement).getText());



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("element is not displayed");
			isDisplayed = false;

		}


		return isDisplayed;
	}


	public String verifytext(String webelement) throws Exception{

		String msgtext = getlocator(webelement).getText();
		log.info("displayed msg is"+ msgtext);
		return msgtext;
	}



}
