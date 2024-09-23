package qaOnkar;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productname="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("qaonkar4@mailinator.com");
		driver.findElement(By.id("userPassword")).sendKeys("Qa@123456");
		driver.findElement(By.id("login")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mb-3")));
	//	Thread.sleep(2000);
		List<WebElement> li=driver.findElements(By.cssSelector(".mb-3"));
		System.out.println(li.size());
		for(int i=0;i<li.size();i++)
		{
			WebElement m=li.get(i);
			String s=m.findElement(By.cssSelector("b")).getText();
			if(s.contains(productname))
			{
				m.findElement(By.cssSelector(".card-body button:last-of-type")).click();
				break;
			}
			System.out.println(s);
			
		}
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='/dashboard/cart']")).click();
		Thread.sleep(2000);
	//	w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".totalRow button"))));
		
	List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	
	System.out.println(cartProducts.get(0).getText());
	Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productname));
	Assert.assertTrue(match);
	
	driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
	Thread.sleep(2000);
//	w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'Place Order')]"))));
	
	Actions a =new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"india" ).build().perform();
	w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ta-results")));
	driver.findElement(By.cssSelector(".ta-item:nth-of-type(1)")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	
	
	
	
	
//	driver.quit();
	}

}
