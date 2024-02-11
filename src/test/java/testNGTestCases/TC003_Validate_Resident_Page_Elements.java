package testNGTestCases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass_BrowserLaunch.Launch;
import entrata_POM.Resident_Page;
import entrata_POM.SignInPage;

public class TC003_Validate_Resident_Page_Elements extends Launch {
	public static Logger logger;
	Resident_Page scheduleDemo; 
	SoftAssert sa=new SoftAssert();
	  
@BeforeMethod
public void url_launch() throws InterruptedException {
		logger=logger.getLogger("zee5_log");
		PropertyConfigurator.configure("log4j.properties");
		launchURL();
		logger.info("URL launched");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		scheduleDemo =new Resident_Page(driver);
		}
	
  @Test
  public void Verify_Schedule_Demo_button_displaying() {
	  logger.info("Validating actual and expected result");
	  sa.assertTrue(scheduleDemo.Verify_Schedule_Demo_button(driver), "TC003: Failed: scheduleDemo not displaying");
	  sa.assertAll();
  }
  
  
  @AfterMethod
  public void close_URL(){
	  logger.info("Closing browser");
	 closeURL(); 
  }
}
