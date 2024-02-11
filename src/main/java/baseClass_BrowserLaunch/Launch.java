package baseClass_BrowserLaunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Launch {
	
	static protected WebDriver driver;
	
public void launchURL(){
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	Reporter.log("Opening Browser ", true);
	driver.get("https://www.entrata.com/");
	
}

public void closeURL(){
	Reporter.log("Closing Browser ", true);
	driver.close();
	
}
}
