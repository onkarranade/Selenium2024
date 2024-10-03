package qaOnkar;

//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import qaOnkar.TestComponents.BaseTest;
import qaOnkar.pageobjects.CartPage;
import qaOnkar.pageobjects.CheckoutPage;
import qaOnkar.pageobjects.ConfirmationPage;
import qaOnkar.pageobjects.DashboardPage;
import qaOnkar.pageobjects.LoginPage;
import qaOnkar.pageobjects.OrdersPage;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;


public class SubmitOrderTest extends BaseTest {
	String productname="ZARA COAT 3";
	//WebDriver driver;
	@Test
	public void Submit() throws IOException, InterruptedException
	{
	LoginPage loginPage=launchApplication();
	
	DashboardPage dashboardPage= new DashboardPage(driver);
	CartPage cartPage= new CartPage(driver);
	CheckoutPage checkoutPage=new CheckoutPage(driver);
	ConfirmationPage confirmationPage=new ConfirmationPage(driver);
	
//	WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(3));
//	loginPage.goTo();
	loginPage.loginApplication("qaonkar4@mailinator.com", "Qa@123456");
	
      List<WebElement> products= dashboardPage.getProductList();
	
	dashboardPage.getProductByName(productname);
	dashboardPage.addProductToCart(productname);
	Thread.sleep(2000);
	Assert.assertTrue(cartPage.verifyCartProducts(productname));
	cartPage.checkOut();
	checkoutPage.selectCountry("India");
	checkoutPage.Submit();
	String confirmMessage=confirmationPage.confirmText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
//	driver.quit();
	}
	
	@Test(dependsOnMethods = {"Submit"})
	public void CheckOrderTest() throws IOException, InterruptedException
	{
		

	OrdersPage ordersPage=new OrdersPage(driver);
	DashboardPage dashboardPage=new DashboardPage(driver);
	dashboardPage.goToOrdersPage();
	Assert.assertTrue(ordersPage.verifyOrderDisplayed(productname));
	}

	

}
