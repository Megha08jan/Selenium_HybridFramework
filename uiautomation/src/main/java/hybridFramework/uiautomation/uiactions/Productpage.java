package hybridFramework.uiautomation.uiactions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hybridFramework.uiautomation.mouseactions.Mouseaction;
import hybridFramework.uiautomation.testbase.Testbase;

public class Productpage extends Testbase {

	public final static Logger log = Logger.getLogger(Productpage.class.getName());

	public int getnoofproducts() throws Exception{
		Mouseaction	mouseaction = new Mouseaction();	
		mouseaction.actionmovetoelementwithclick(getlocator("clickonwomen"));
		List<WebElement> list = getlocators("listofproducts");
		log.info("total items are"+ " " + list.size());
		return list.size();

	}


}
