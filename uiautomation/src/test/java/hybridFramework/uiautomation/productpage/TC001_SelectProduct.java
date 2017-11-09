package hybridFramework.uiautomation.productpage;

import java.io.IOException;

import hybridFramework.uiautomation.testbase.Testbase;
import hybridFramework.uiautomation.uiactions.Homepage;
import hybridFramework.uiautomation.uiactions.LoginPage;
import hybridFramework.uiautomation.uiactions.Productpage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC001_SelectProduct extends Testbase {


	public final static Logger log = Logger.getLogger(TC001_SelectProduct.class.getName());
	public Homepage homepage;
	public LoginPage loginpage;
	public Productpage productpage;
	int productcount;
	String path = System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\uiautomation\\data\\Testdata1.xlsx";
	String sheetname;
	@BeforeClass
	public void init() throws Exception{

		setup();
	}


	@DataProvider(name = "Login")
	public Object[][] loaddata() throws IOException{
		sheetname = "LoginDetails";
		String[][] dataset = getdata(path,sheetname);
		return dataset;

	}

	@Test(dataProvider="Login",priority=0)
	public void logintowebsite(String emailid, String pwd, String runmode) throws Exception{

		if(runmode.equalsIgnoreCase("n")){

			throw new SkipException("masrked as no run");
		}

		try {
			homepage = new Homepage(driver);
			loginpage = homepage.clickonsignin();	
			loginpage.logintowebsite(emailid, pwd);
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false);
			log.info("exception occured");
			e.printStackTrace();

		}


	}

	@DataProvider(name="products")
	public Object[][] loaddata1() throws IOException{
		sheetname = "Productsdetails";
	String[][]	dataset = getdata(path,sheetname);

		return dataset;


	}
	int productno;
	@Test(priority=1, dataProvider="products")
	public void productdetails(String productno, String runmode){
		
		if(runmode.equalsIgnoreCase("n")){

			throw new SkipException("masrked as no run");
		}

		try{

			productpage = homepage.womenproducts();
			productcount =productpage.getnoofproducts();
			Assert.assertEquals(productcount,7);
			this.productno = Integer.parseInt(productno);
			productpage.selectproduct(this.productno);

		} catch(AssertionError e){
			Assert.assertTrue(false, "count is not equal");
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false);
			log.info("exception occured");
			e.printStackTrace();

		}



	}





}
