package coverFoxTestNGTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
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


public class ValidatePlanResult extends CoverFoxLaunch {
	CoverFox_HomePage home;
	CoverFox_HealthPlanPage members;
	CoverFox_HealthPlanMemberDetailsPage age;
	CoverFox_healthPlanAddressDetails details;
	CoverFox_HealthPlansResult plan;
	
	@BeforeClass
	public void url_launchCoverFox() throws InterruptedException {
		launchCoverFoxURL();
		home= new CoverFox_HomePage(driver);
		members=new CoverFox_HealthPlanPage(driver);
		age=new CoverFox_HealthPlanMemberDetailsPage(driver);
		details=new CoverFox_healthPlanAddressDetails(driver);
		plan=new CoverFox_HealthPlansResult(driver);
		}
	
	@BeforeMethod
	public void preRequisitesCoverFox() throws EncryptedDocumentException, InterruptedException, IOException {
		home.clickFemaleRadioButton();
		members.click_nextButton();
		age.select_ageFromDropDown(utility_Methods.Utility_CommonMethods.readData_Excel(0, 0));
		age.click_nextButton();
		details.enter_PinCode(utility_Methods.Utility_CommonMethods.readData_Excel(0, 1));
		details.enter_MobileNumber(utility_Methods.Utility_CommonMethods.readData_Excel(0, 2));
		details.click_ContinueButton();
	}
  @Test
  public void validatePlanResultsCoverFox() throws InterruptedException {
	  int text = plan.shownResult_Text();
	  int banner = plan.shownResult_Banner();
	  Reporter.log("Validating expected and actual result ", true);
	  Assert.assertEquals(text, banner,"TC failed: text and banner result not matching");
	  
  }
  
  @AfterMethod
  public void url_CloseCoverFox() throws InterruptedException {
	 closeCoverFoxURL(); 
  }
}
