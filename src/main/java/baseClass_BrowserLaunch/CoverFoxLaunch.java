package baseClass_BrowserLaunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class CoverFoxLaunch {
	
	static protected WebDriver driver;
	
public void launchCoverFoxURL() throws InterruptedException {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	Reporter.log("Opening Browser ", true);
	driver.get("https://www.coverfox.com/");
	Thread.sleep(1000);
}

public void closeCoverFoxURL() throws InterruptedException {
	Reporter.log("Closing Browser ", true);
	Thread.sleep(1000);
	driver.close();
	Thread.sleep(3000);
}
}
