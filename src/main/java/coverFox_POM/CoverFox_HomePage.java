package coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFox_HomePage {
    //variable
	@FindBy(xpath = "//div[text()='Female']") private WebElement female_radioButton;
	
	//Constructor
	public CoverFox_HomePage (WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public void clickFemaleRadioButton() {
		female_radioButton.click();
	}
}
