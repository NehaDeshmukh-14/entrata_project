package coverFoxTestNGTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass_BrowserLaunch.CoverFoxLaunch;
import coverFox_POM.CoverFox_HealthPlanMemberDetailsPage;
import coverFox_POM.CoverFox_HealthPlanPage;
import coverFox_POM.CoverFox_HealthPlansResult;
import coverFox_POM.CoverFox_HomePage;
import coverFox_POM.CoverFox_healthPlanAddressDetails;

public class ValidateFilterStarHealth extends CoverFoxLaunch {
	CoverFox_HomePage home;
	CoverFox_HealthPlanPage members;
	CoverFox_HealthPlanMemberDetailsPage age;
	CoverFox_healthPlanAddressDetails details;
	CoverFox_HealthPlansResult plans;
	
	@BeforeClass
	public void launch_CoverFox() throws InterruptedException {
		launchCoverFoxURL();
		home=new CoverFox_HomePage(driver);
		members=new CoverFox_HealthPlanPage(driver);
		age=new CoverFox_HealthPlanMemberDetailsPage(driver);
		details=new CoverFox_healthPlanAddressDetails(driver);
		plans=new CoverFox_HealthPlansResult(driver);
		
	}
	@BeforeMethod
	public void prerequisites() throws InterruptedException, IOException {
		home.clickFemaleRadioButton();
		members.click_nextButton();
		age.select_ageFromDropDown(utility_Methods.Utility_CommonMethods.coverFoxPropertyFileData("age"));
		age.click_nextButton();
		details.enter_PinCode(utility_Methods.Utility_CommonMethods.coverFoxPropertyFileData("pincode"));
		details.enter_MobileNumber(utility_Methods.Utility_CommonMethods.coverFoxPropertyFileData("mobile"));
	details.click_ContinueButton();

	}
	
  @Test
  public void validateFilterIsApplied() throws InterruptedException {
	  boolean result = plans.validate_BrandFilterIsCorrectlyApplied();
	 Assert.assertTrue(result, "TC failed:Brand filter not applicable");
  }
  
  @AfterMethod
  public void closeURL() throws InterruptedException {
	  closeCoverFoxURL();
  }
}
