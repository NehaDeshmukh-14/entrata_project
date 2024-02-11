package entrata_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	        //variable
			@FindBy(xpath = "(//div[@class='button-holder']/child::a[text()='Watch Demo'])[1]") private WebElement Watch_Demo_Home_Page;
			@FindBy(xpath = "(//a[text()='Sign In'])[1]") private WebElement Sign_In_Home_Page;
			
			
			//Constructor
			public Home_Page (WebDriver driver){
				PageFactory.initElements(driver, this);
			}
			
			//Methods
			public boolean Verify_Watch_Demo_button_From_Home_Page() {
				boolean result_watch_demo = Watch_Demo_Home_Page.isDisplayed();
				return result_watch_demo;
				
			}
			
			public boolean Verify_Sign_In_Button_Home_Page() {
				boolean result_sign_In = Sign_In_Home_Page.isEnabled();
				return result_sign_In;
			}
			
			
}
