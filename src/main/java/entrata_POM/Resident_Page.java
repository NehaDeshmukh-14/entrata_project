package entrata_POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resident_Page {
	//Variable
	@FindBy(xpath ="(//div[@class='header-nav-item'])[1]") private WebElement products_tab_Home_Page;
	@FindBy(linkText="ResidentPay") private WebElement ResidentPay;
	@FindBy(linkText="Schedule Demo") private WebElement Schedule_Demo_button;
	
	
	//Constructor
	public Resident_Page (WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public boolean Verify_Schedule_Demo_button(WebDriver driver) {
		products_tab_Home_Page.click();
		ResidentPay.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		boolean result_Schedule_Demo_button = Schedule_Demo_button.isDisplayed();
		return result_Schedule_Demo_button;				
}
}
