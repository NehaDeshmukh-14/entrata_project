package coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoverFox_HealthPlanMemberDetailsPage {
    //variable
	@FindBy(xpath = "//select[@id='Age-You']") private WebElement age_drop_down;
	@FindBy(xpath = "//div[text()='Next']") private WebElement next_button;
	
	//Constructor
	public CoverFox_HealthPlanMemberDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public void select_ageFromDropDown(String age) throws InterruptedException {
		age_drop_down.click();
		Thread.sleep(1000);
		Select s=new Select(age_drop_down);
		Thread.sleep(1000);
		s.selectByValue(age+"y");
	}
	
	public void click_nextButton() throws InterruptedException {
		Thread.sleep(1000);
		next_button.click();
	}
}
