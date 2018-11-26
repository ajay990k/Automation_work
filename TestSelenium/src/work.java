import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;
public class work {
	@Test
	public void yest() throws IOException
	{
	System.setProperty("webdriver.chrome.driver",
			"D:\\Selenuim\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();

	
	driver.get("http://google.com");
	
File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src,new File("C:\\Users\\rahul\\screenshot.png"));
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	
		
	}

}
