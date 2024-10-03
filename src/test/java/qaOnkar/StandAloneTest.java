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
import qaOnkar.pageobjects.CartPage;
import qaOnkar.pageobjects.CheckoutPage;
import qaOnkar.pageobjects.ConfirmationPage;
import qaOnkar.pageobjects.DashboardPage;
import qaOnkar.pageobjects.LoginPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productname="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		LoginPage loginPage=new LoginPage(driver);
		DashboardPage dashboardPage= new DashboardPage(driver);
		CartPage cartPage= new CartPage(driver);
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		ConfirmationPage confirmationPage=new ConfirmationPage(driver);
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
	//	driver.get("https://rahulshettyacademy.com/client");
		loginPage.goTo();
		loginPage.loginApplication("qaonkar4@mailinator.com", "Qa@123456");
		
	      List<WebElement> products= dashboardPage.getProductList();
		
		dashboardPage.getProductByName(productname);
		dashboardPage.addProductToCart(productname);
	

		
	//	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	//	w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//driver.findElement(By.cssSelector("[routerlink*='/dashboard/cart']")).click();
		Thread.sleep(2000);
		//w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".totalRow button"))));
		
	//List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	
	//System.out.println(cartProducts.get(0).getText());
	//Boolean match=cartPage.verifyCartProducts(productname);
	Assert.assertTrue(cartPage.verifyCartProducts(productname));
	cartPage.checkOut();
	//driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
//	Thread.sleep(2000);
//	w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'Place Order')]"))));
	
	checkoutPage.selectCountry("India");
	checkoutPage.Submit();
	
//	driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("india");
	//Actions a =new Actions(driver);
//	a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"india" ).build().perform();
//	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	//driver.findElement(By.cssSelector(".ta-item:nth-of-type[1]")).click();
//	driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
	//driver.findElement(By.cssSelector(".action__submit")).click();
	
	//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
//	String confirmMessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
	String confirmMessage=confirmationPage.confirmText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	driver.quit();
	}

	}
