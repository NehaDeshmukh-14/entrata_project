package coverFox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFox_HealthPlansResult {
    //variable
	@FindBy(xpath = "//div[contains(text(),'matching Health')]") private WebElement matching_Results;
	@FindBy(xpath = "//div[@id='plans-list']") private List<WebElement> listOfPlan;
	@FindBy(xpath = "(//div[@class='filter-sec'])[3]") private WebElement brand_filter;
	@FindBy(xpath = "//div[@class='values-box']/div") private List<WebElement> apply_filter;
	@FindBy(xpath = "//button[@class='apply-btn']") private WebElement apply_filterButton;
	@FindBy(xpath = "//button[text()='Buy Now']") private List<WebElement> matchings_afterBrand_StarHealthFilter;
	
	//constructor
	public CoverFox_HealthPlansResult(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public int shownResult_Text() throws InterruptedException {
		Thread.sleep(7000);
		String result_shown = matching_Results.getText();
		//System.out.println(result_shown);
		Thread.sleep(1000);
		String[] s = result_shown.split(" ");
		String st = s[0];
		int valueShown = Integer.parseInt(st);
		return valueShown;
		}
	
	public int shownResult_Banner() {
		
		int actual_plansShown = listOfPlan.size();
		return actual_plansShown;
	}
	
	public void validate_OptionsInBrandFilter() throws InterruptedException {
		brand_filter.click();
		Thread.sleep(7000);
		for(WebElement af:apply_filter) {
			//System.out.println(af.getText());
		}
	}
	
	public boolean validate_BrandFilterIsCorrectlyApplied() throws InterruptedException {
		Thread.sleep(7000);
		brand_filter.click();
		for(WebElement af1:apply_filter) {
			if(af1.getText().equals("Star Health Insurance")) {
				af1.click();
				System.out.println("Filter Applied: Brand: Star Health Insurance:PASS"); 
				}
		}
		return true;	
	}
	
	
	public int NoOfMatchesShownAtferFilterAplied() throws InterruptedException {
		apply_filterButton.click();
		Thread.sleep(7000);
		String result_shown1 = matching_Results.getText();
		System.out.println("Result after filter application: "+result_shown1);	
		//System.out.println(result_shown1);
		Thread.sleep(1000);
		String[] s = result_shown1.split(" ");
		String st1 = s[0];
		int valueShown1 = Integer.parseInt(st1);
		return valueShown1;
			
	}
	public int bannerResultAfterFilterApplication() throws InterruptedException {
		Thread.sleep(1000);
		int actual_plansShown1 = matchings_afterBrand_StarHealthFilter.size();
		//System.out.println(actual_plansShown1);
		return actual_plansShown1;  
	}
	}
	

