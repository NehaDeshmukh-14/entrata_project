package utility_Methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility_CommonMethods {
	
public static void takeScreenshotmethod(WebDriver driver, String mytestname) throws IOException {
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String scDate=new SimpleDateFormat("DD.MM.YYYY.HH.MM.SS").format(new Date());
	File dest=new File("C:\\Users\\admin\\eclipse-workspace\\Entrata\\Screenshot"+mytestname+scDate+".png");
	FileHandler.copy(src, dest);
}

public static String Entrata_PropertyFileData(String key) throws IOException, InterruptedException {
	Properties prop=new Properties();
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Entrata_form_Data.properties");
	prop.load(file);
	String value = prop.getProperty(key);
	return value;
}



}

