package coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFox_HealthPlanPage {
	//variable
	@FindBy(xpath = "//div[@class='next-btn']") private WebElement next_Button;
	
	//Constructor
	public CoverFox_HealthPlanPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public void click_nextButton() throws InterruptedException{
		Thread.sleep(2000);
		next_Button.click();
	}

}
