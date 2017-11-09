package hybridFramework.uiautomation.mouseactions;

import hybridFramework.uiautomation.testbase.Testbase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mouseaction extends Testbase {

	public static final Logger log = Logger.getLogger(Mouseaction.class.getName());
	WebDriver driver;

	public Mouseaction(WebDriver driver) {
		this.driver = driver;

	}

	Actions action;
	public void actionmovetoelementwithoutclick(WebElement target){
		action = new Actions(driver);
		log.info("element is "+target.toString());
		action.moveToElement(target).build().perform();

	}
	public void actionmovetoelementwithclick(WebElement target){
		action = new Actions(driver);
		log.info("element is "+target.toString());

		action.moveToElement(target).click().build().perform();

	}

	public void randomclick(){
		action = new Actions(driver);
		log.info("perform random click");
		action.click().build().perform();
	}

	public void clickonwebelement(WebElement target){
		action = new Actions(driver);
		log.info("click on "+target.toString());	
		action.click(target).build().perform();
	}


}
