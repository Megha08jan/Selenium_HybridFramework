package hybridFramework.uiautomation.customlistener;

import hybridFramework.uiautomation.testbase.Testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener extends Testbase implements ITestListener {

	public static final Logger log = Logger.getLogger(Listener.class.getName());

	Calendar calender = Calendar.getInstance();

	SimpleDateFormat dateformat =  new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	String methodname;
	
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		methodname = result.getName();
        
		log.info(methodname);
		
		if(result.isSuccess()){
			try {
				File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String imagelocation = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\hybridFramework\\uiautomation\\";
				File destfile = new File(imagelocation + "\\passed screenshots\\"+methodname+ "_"+dateformat.format(calender.getTime())+".png");	

				FileUtils.copyFile(srcfile, destfile);
				Reporter.log("<a href = ' " + destfile.getAbsolutePath() + " '> <img src=' " + destfile.getAbsolutePath() + " ' height = '100' width = '100'/> </a>");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}



	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		methodname = result.getName();
          
		log.info(methodname);
		
		if(!result.isSuccess()){
			try {
				File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String imagelocation = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\hybridFramework\\uiautomation\\";
				File destfile = new File(imagelocation + "\\failed screenshots\\"+methodname+ "_"+dateformat.format(calender.getTime())+".png");	

				FileUtils.copyFile(srcfile, destfile);
				Reporter.log("<a href = ' " + destfile.getAbsolutePath() + " '> <img src=' " + destfile.getAbsolutePath() + " ' height = '100' width = '100'/> </a>");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}



}
