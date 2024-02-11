package testNGTestCases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass_BrowserLaunch.Launch;
import entrata_POM.Home_Page;
 
public class TC001_Validate_Elements_On_HomePage extends Launch {
	
	public static Logger logger;
	Home_Page home_page_elements; 
	SoftAssert sa=new SoftAssert();
	  
@BeforeMethod
public void url_launch() throws InterruptedException {
		logger=logger.getLogger("zee5_log");
		PropertyConfigurator.configure("log4j.properties");
		launchURL();
		logger.info("URL launched");
		home_page_elements =new Home_Page(driver);
		}
	
  @Test
  public void validate_dispalyOf_Watch_Demo_button_From_Home_Page() throws InterruptedException  {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	  logger.info("Validating actual and expected result");
	  sa.assertTrue(home_page_elements.Verify_Watch_Demo_button_From_Home_Page(), "TC0011: Failed: Element is not visible");
	  sa.assertAll();
	  }
  
  @Test
  public void validate_Sign_In_Button_Enabled_from_Home_Page() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	  logger.info("Validating actual and expected result");
	  sa.assertTrue(home_page_elements.Verify_Sign_In_Button_Home_Page(), "TC0012: Failed: Element is disable");
	  sa.assertAll();
  }
  
  
  @AfterMethod
  public void close_URL(){
	  logger.info("Closing browser");
	 closeURL(); 
  }
}
