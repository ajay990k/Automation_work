import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class test {
	public static void main(String[] args) {
		WebDriver driver=null;
		
		try{
			System.setProperty("webdriver.chrome.driver","D:\\Selenuim\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://amazon.in");
			driver.manage().window().fullscreen();
			//driver.manage().window().maximize();
			//System.out.println(driver.getCurrentUrl());
			String title=driver.getTitle();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
			
			System.out.println("password"+System.getenv("password"));
			if(title.equals("Google"))
			{
				System.out.println("passed");
			}
			else{
				System.out.println("failed");
			}

			/*WebDriverWait wait =new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='emal']")));
*/
			//WebElement email=driver.findElement(By.xpath("//input[@id='email']"));

			//email.clear();
			//email.sendKeys("facebook");
			//
			driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("lusson");
			driver.findElement(By.id("login-form-username")).sendKeys("kj");
			driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
			
			driver.findElement(By.xpath("//*[@id='result_0']/div/div/div/div[2]/div[1]/div[1]/a/h2")).click();
			//Thread.sleep(5000);
			
			String mainScreen=driver.getWindowHandle();
			System.out.println(mainScreen);
			
			for(String screens:driver.getWindowHandles())
			{
				if(!screens.equals(mainScreen))
				{
					System.out.println(screens);
					driver.switchTo().window(screens);
					System.out.println("current screen:"+driver.getWindowHandle());
				}
			}
			
			driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
		}
		catch(Exception e){
			System.out.println("L to lagg hi gaye hai "+e.getMessage());
		}
		finally{
			driver.quit();
		}
	}
}