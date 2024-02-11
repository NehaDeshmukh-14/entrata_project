package listeners;


import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import baseClass_BrowserLaunch.Launch;
import utility_Methods.Utility_CommonMethods;

public class Listener extends Launch implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		String r = result.getName();
	Reporter.log("TC "+r+" Execution started", true);	
	
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("TC "+result.getName()+" Execution skipped", true);		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("TC "+result.getName()+" Execution Failed", true);	
		
			try {
				Reporter.log("listener is running", true);
				Utility_CommonMethods.takeScreenshotmethod(driver, result.getName());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("TC "+result.getName()+" Execution successful", true);	
		Reporter.log("TC "+result.getName()+" Execution Started", true);	
		
		try {
			Reporter.log("listener is running", true);
			Utility_CommonMethods.takeScreenshotmethod(driver, result.getName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
