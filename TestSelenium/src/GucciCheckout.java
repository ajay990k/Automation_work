
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;



public class GucciCheckout {

	WebElement findElement(WebDriver driver,String xpath) throws AWTException
	{
		explicitWait(driver, xpath);
		WebElement ele=driver.findElement(By.xpath(xpath));

		return ele;

	}

	List<WebElement> findElements(WebDriver driver,String xpath)
	{
		explicitWait(driver, xpath);
		List<WebElement> ele=driver.findElements(By.xpath(xpath));
		return ele;

	}

	void explicitWait(WebDriver driver,String xpath)
	{
		WebDriverWait wait =new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
	}

	void checkout() throws InterruptedException, AWTException{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenuim\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://horsebit:U-gVcC!oN3@stg.edge.regiongold.com/us/en/");
		//driver.get("https://horsebit:U-gVcC!oN3@qa1.edge.regiongold.com/us/en/");
		driver.get("https://www.gucci.com/us/en/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		int count1= findElements(driver,"//button[@class='international-overlay-close overlay-close']").size();
		if(count1>0)
		{ System.out.println("Dialog Box appear and closed as you must have also seen");
		findElement(driver,"//button[@class='international-overlay-close overlay-close']").click();
		}
		else
		{
			System.out.println("Dialog Box Did not appear");
		}


		Thread.sleep(5000);
		try{
			findElement(driver,"//a[contains(@href,'signIn') and contains(text(),'Sign In') and contains(@class,'header')]").click();
		}
		catch(Exception e)
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_F5);
			r.keyRelease(KeyEvent.VK_F5);
			findElement(driver,"//a[contains(@href,'signIn') and contains(text(),'Sign In') and contains(@class,'header')]").click();
		}
		// System.out.println(driver.findElement(By.xpath("//a[@id='header-nav-signin-anchor']")).isDisplayed());
		// driver.findElement(By.id("header-nav-signin-anchor")).click();
		//WebDriverWait d =new WebDriverWait(driver, 10);
		//d.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.id("header-nav-signin-anchor"))));
		//Thread.sleep(5000L);

		//	java.util.List<WebElement> list = driver.findElements(By.id("header-nav-signin-anchor"));
		//
		//	int count = list.size();
		//	for (int i = 0; i < count; i++)
		//	{
		//		int x = list.get(i).getLocation().getX();
		//		if (x != 0) {
		//			System.out.println("X coordinate is :" +x);
		//			list.get(i).click();
		//			break;
		//		}


		driver.findElement(By.id("j_username")).sendKeys("abc12345@gmail.com");
		driver.findElement(By.id("j_password")).sendKeys("Gucci@123");
		findElement(driver,"//form[@id='loginPageForm']//button[@type='submit'][contains(text(),'Sign In')]").click();

		//To Open Search Bar
		findElement(driver,"//a[contains(@class,'js-search-bar-btn')]").click();
		//Thread.sleep(2000L);
		//productspecific prod-3, qa 2 space stg 1 space 500877DRW009522 
		findElement(driver,"//a[contains(@class,'js-search-bar-btn')]").sendKeys("     Gucci logo leather sneaker");
		findElement(driver,"//form[@id='header-nav-search']//button[@type='submit']").click();
		//productspecific
		findElement(driver,"//body[contains(@class,'language-en')]/div[@id='mm-0']/div[@id='page']/div[contains(@class,'span-18 last')]/div[contains(@class,'content search-results')]/section[contains(@class,'search-results-grid')]/div[contains(@class,'product-tiles-grid')]/article[contains(@class,'product-tiles-grid-item product-tiles-grid-item-medium product-tiles-grid-item-small hover-link')]/a[@id='500877DRW009522']/div[contains(@class,'product-tiles-grid-item-image-wrapper')]/div[contains(@class,'product-tiles-grid-item-image')]/img[1]").click();
		Thread.sleep(5000L);
		findElement(driver,"//p[contains(text(),'Select Size')]").click();
		findElement(driver,"//li[contains(text(),' Select Size')]/parent::ul//span[text()='5 = 6 US']").click();
		findElement(driver,"//button[@class='shopping-bag-cta add-to-shopping-bag']").click();


		//findElement(driver,"//button[contains(text(),'Add to Shopping Bag')]").click();
		Thread.sleep(3000L);
		driver.findElement(By.cssSelector("#header-nav-bag-anchor")).click();
		findElement(driver,"//a[contains(@class,'button-standard')]").click();
		Thread.sleep(4000L);
		findElement(driver, "//input[@id='input-credit-card-number']").sendKeys("4111111111111111");
		findElement(driver, "//input[@id='input-credit-card-code-new']").sendKeys("123");

		findElement(driver, "//input[@id='input-credit-card-name']").sendKeys("Ajay Kukreja");
		findElement(driver,"//p[text()='MM']").click();
		findElement(driver,"//li[text()='01']").click();
		findElement(driver,"//p[text()='YYYY']").click();
		findElement(driver,"//li[text()='2019']").click();

		findElement(driver,"//button[text()='Confirm Details']").click();

		Robot r=new Robot();
		Actions action=new Actions(driver);
		//action.moveToElement(findElement(driver,"(//a[@class='overlay-open'])[2]")).build().perform();

		WebElement ele=driver.findElement(By.xpath("(//a[@class='overlay-open'])[2]"));
		ele.click();
		findElement(driver, "(//button[text()='Close'])[2]").click();
		int x=ele.getLocation().getX();
		System.out.println("x:"+x);
		int y=ele.getLocation().getY();

		System.out.println("y:"+y);

		
		r.mouseWheel(60);
		for(int i=0;i<100;i++)
		{
			x=x-1;

			System.out.println("x & y"+x +" "+ y);
			action.moveByOffset(x, y).click().build().perform();
		}

	}		
	/*	
	//		WebDriverWait d1 =new WebDriverWait(driver,15);
	//		d1.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(".button-standard.button-block"))));

	//driver.findElement(By.xpath("//button[@class='proceed-order-btn button-place-order button-standard button-block']")).click();
	//driver.findElement(By.xpath("//label[@for='place-order-terms']")).click();

	//System.out.println(driver.findElement(By.xpath(("//label[@for='place-order-terms'])[2])"))).isDisplayed());
	//System.out.println(driver.findElement(By.cssSelector(".button-standard.button-block")).isDisplayed());
	System.out.println(driver.findElement(By.cssSelector("label[for='place-order-terms']")).isSelected());
	System.out.println(driver.findElement(By.cssSelector("label[for='place-order-terms']")).isDisplayed());

	//System.out.println(driver.findElement(By.cssSelector("label::before")).isSelected());
	//driver.findElement(By.cssSelector("label[for='place-order-terms']")).click();
	//driver.findElement(By.xpath(("//label[@for='place-order-terms'])[2]"))).click();
	//driver.findElement(By.xpath(("(//input[@id='place-order-terms'])[2]"))).click();

	java.util.List<WebElement> list1 = driver.findElements(By.cssSelector("label[for='place-order-terms']"));

	int count2 = list1.size();
	System.out.println(count2);
	for (int i = 0; i < count2; i++) {
		int x = list1.get(i).getLocation().getX();
		if (x != 0) {
			System.out.println("2nd X coordinate is :" + x);
			//list1.get(i).click();
			Actions a = new Actions(driver);
			WebElement move = list1.get(i);
			a.click(move).build().perform();
			break;
		}
	}
	//System.out.println(driver.findElement(By.className("label::before")).isSelected());

}




	 */
	// driver.switchTo().alert().accept();

	// driver.close();
	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		GucciCheckout g =new GucciCheckout();
		g.checkout();


	}
}

