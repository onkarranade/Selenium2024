package qaOnkar;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import qaOnkar.TestComponents.BaseTest;
import qaOnkar.pageobjects.CartPage;
import qaOnkar.pageobjects.CheckoutPage;
import qaOnkar.pageobjects.ConfirmationPage;
import qaOnkar.pageobjects.DashboardPage;
import qaOnkar.pageobjects.LoginPage;

public class CheckOrderTest extends BaseTest {

	
	String productname="ZARA COAT 3";
	
	
	@Test
	
	public void orderPage() throws IOException
	{
		LoginPage loginPage=launchApplication();
		loginPage.loginApplication("qaonkar4@mailinator.com", "Qa@123456");
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.goToOrdersPage();
		driver.quit();
	}
}
