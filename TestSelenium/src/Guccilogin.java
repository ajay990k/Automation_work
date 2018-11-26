import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Guccilogin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenuim\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://horsebit:U-gVcC!oN3@qa1.edge.regiongold.com/us/en/");
		// driver.get("https://qa1.edge.regiongold.com/us/en/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//button[@class='international-overlay-close overlay-close']"))
				.click();
		// System.out.println(driver.findElement(By.xpath("//a[@id='header-nav-signin-anchor']")).isDisplayed());
		// driver.findElement(By.id("header-nav-signin-anchor")).click();
		java.util.List<WebElement> list = driver.findElements(By
				.id("header-nav-signin-anchor"));

		int count = list.size();
		for (int i = 0; i < count; i++)
		{
			int x = list.get(i).getLocation().getX();
			if (x != 0) {

				list.get(i).click();
				break;
			}

		}
		driver.findElement(By.id("j_username")).sendKeys("abc12345@gmail.com");
		driver.findElement(By.id("j_password")).sendKeys("Gucci@123");
		driver.findElement(By.xpath("//form[@id='loginPageForm']//button[@type='submit'][contains(text(),'Sign In')]")).click();
		
		// Actions a = new Actions(driver);
		// WebElement move = driver.findElement(By
		// .xpath("//a[contains(text(),'Shop men')]"));
		//
		// a.moveToElement(move).click().build().perform();

		// driver.switchTo().alert().accept();
		// driver.findElement(By.id("login-form-username")).sendKeys("ajay.kukreja");
		// System.out.println(driver.getTitle());
		// driver.close();

	}

}
