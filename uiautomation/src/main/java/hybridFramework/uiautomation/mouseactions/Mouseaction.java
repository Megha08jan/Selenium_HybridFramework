package hybridFramework.uiautomation.mouseactions;

import hybridFramework.uiautomation.testbase.Testbase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mouseaction extends Testbase {

	public static final Logger log = Logger.getLogger(Mouseaction.class.getName());
	
	Actions action = new Actions(driver);
	public void actionmovetoelementwithoutclick(WebElement target){
        log.info("element is "+target.toString());
		action.moveToElement(target).build().perform();

	}
	public void actionmovetoelementwithclick(WebElement target){

		log.info("element is "+target.toString());
	
		action.moveToElement(target).click().build().perform();

	}
	
	public void randomclick(){
		log.info("perform random click");
	action.click().build().perform();
	}
	
	public void clickonwebelement(WebElement target){
		log.info("click on "+target.toString());	
		action.click(target).build().perform();
	}


}
