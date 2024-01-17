package utility_Methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Utility_CommonMethods {
	
public static void takeScreenshotmethod(WebDriver driver, String mytestname) throws IOException {
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String scDate=new SimpleDateFormat("DD.MM.YYYY.HH.MM.SS").format(new Date());
	File dest=new File("C:\\Users\\admin\\Desktop\\imp question neha\\Screenshot\\"+mytestname+scDate+".png");
	FileHandler.copy(src, dest);
}

public static void scrollIntoView(WebDriver driver, WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();", element);
}

public static void implicit_wait(WebDriver driver, int time) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
}

public static String readData_Excel(int row, int cell) throws EncryptedDocumentException, IOException {
	FileInputStream myfile=new FileInputStream("C:\\Users\\admin\\Documents\\program_excelsheet.xlsx");
	Sheet mysheet = WorkbookFactory.create(myfile).getSheet("CoverFoxTestData");
	String data = mysheet.getRow(row).getCell(cell).getStringCellValue();
	return data;
	
}

public static String coverFoxPropertyFileData(String key) throws IOException, InterruptedException {
	Properties prop=new Properties();
	Thread.sleep(1000);
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\CoverFox.properties");
	prop.load(file);
	Thread.sleep(1000);
	String value = prop.getProperty(key);
	return value;
}



}

