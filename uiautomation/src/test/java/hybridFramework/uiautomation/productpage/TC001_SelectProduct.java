package hybridFramework.uiautomation.productpage;

import hybridFramework.uiautomation.testbase.Testbase;
import hybridFramework.uiautomation.uiactions.Homepage;
import hybridFramework.uiautomation.uiactions.LoginPage;
import hybridFramework.uiautomation.uiactions.Productpage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC001_SelectProduct extends Testbase {


	public final static Logger log = Logger.getLogger(TC001_SelectProduct.class.getName());
	public Homepage homepage;
	public LoginPage loginpage;
	public Productpage productpage;
	int productcount;
	@BeforeClass
	public void init() throws Exception{

		setup();
	}


	@Test
	public void checknoofproduct() throws Exception{
		try {
			homepage = new Homepage();
			loginpage = homepage.clickonsignin();	
			loginpage.logintowebsite("megha08jan@gmail.com", "password");
			productpage = homepage.womenproducts();
			productcount =productpage.getnoofproducts();
			Assert.assertEquals(productcount, 7);
		} catch(AssertionError e){
			Assert.assertTrue(false, "count is not equal");
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("exception occured");
			e.printStackTrace();

		}


	}

}
