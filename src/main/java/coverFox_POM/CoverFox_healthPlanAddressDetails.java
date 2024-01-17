package coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFox_healthPlanAddressDetails {
    //variable
	@FindBy(xpath = "//input[@class='mp-input-text']") private WebElement pincode_field;
	@FindBy(xpath = "//input[@id='want-expert']") private WebElement mobile_NumberField;
	@FindBy(xpath = "//div[text()='Continue']") private WebElement continue_Button; 
	@FindBy(xpath = "//div[@class='error-ui']") private WebElement error_MessagePinCode;
	//constructor
	public CoverFox_healthPlanAddressDetails(WebDriver  driver){
		PageFactory.initElements(driver, this); 
	}
	
	//Methods
	public void enter_PinCode(String pinCode) throws InterruptedException {
		Thread.sleep(1000);
		pincode_field.sendKeys(pinCode);
	}
	public void enter_MobileNumber(String mobile_number) throws InterruptedException {
		Thread.sleep(1000);
		mobile_NumberField.sendKeys(mobile_number);
	}
	public void click_ContinueButton() throws InterruptedException {
		Thread.sleep(1000);
		continue_Button.click();
	}
	public boolean Verify_error_MessagePinCode() {
		boolean r = error_MessagePinCode.isDisplayed();
		return r;
	}
}
