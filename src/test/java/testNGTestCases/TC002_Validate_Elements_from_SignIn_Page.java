package testNGTestCases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass_BrowserLaunch.Launch;
import entrata_POM.SignInPage;

public class TC002_Validate_Elements_from_SignIn_Page extends Launch{
	public static Logger logger;
	SignInPage signIn; 
	SoftAssert sa=new SoftAssert();
	  
@BeforeMethod
public void url_launch() throws InterruptedException {
		logger=logger.getLogger("zee5_log");
		PropertyConfigurator.configure("log4j.properties");
		launchURL();
		logger.info("URL launched");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		signIn =new SignInPage(driver);
		}
	
  @Test
  public void validate_Property_Manager_Login_Link_correctly_navigating_to_desired_Page() {
	  logger.info("Validating actual and expected result");
	  sa.assertEquals(signIn.Verify_Property_Manager_Login_Link_correctly_navigating(driver), "Sso Login","TC002: Failed: Navigating to wrong page");
	  sa.assertAll();
  }
  
  
  @AfterMethod
  public void close_URL(){
	  logger.info("Closing browser");
	 closeURL(); 
  }
}


