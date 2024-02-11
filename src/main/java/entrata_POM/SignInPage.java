package entrata_POM;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	@FindBy(xpath = "(//a[text()='Sign In'])[1]") private WebElement Sign_In_Home_Page;	
	@FindBy(linkText="Property Manager Login")private WebElement Property_Manager_Login_Link;
	@FindBy(id="rcc-decline-button")private WebElement cookies;
	
	//Constructor
	public SignInPage (WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public String Verify_Property_Manager_Login_Link_correctly_navigating(WebDriver driver) {
		Sign_In_Home_Page.click();
		cookies.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
	    Property_Manager_Login_Link.click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	    String title = driver.getTitle();
	    return title;			
}

}
