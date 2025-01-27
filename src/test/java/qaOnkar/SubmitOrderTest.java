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
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;


public class SubmitOrderTest extends BaseTest {
	//String productname="ZARA COAT 3";
	//WebDriver driver;
	@Test(dataProvider = "emailData" , groups = {"submitOrder"})
	public void Submit(String email,String password,String productname) throws IOException, InterruptedException
	{
	LoginPage loginPage=launchApplication();
	
	DashboardPage dashboardPage= new DashboardPage(driver);
	CartPage cartPage= new CartPage(driver);
	CheckoutPage checkoutPage=new CheckoutPage(driver);
	ConfirmationPage confirmationPage=new ConfirmationPage(driver);
	
//	WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(3));
//	loginPage.goTo();
	loginPage.loginApplication(email, password);
	
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
	
	
	@Test(dataProvider = "hashMapData" , groups = {"hashMapData"})
	public void SubmitMap(HashMap<String, String> input) throws IOException, InterruptedException
	{
	LoginPage loginPage=launchApplication();
	
	DashboardPage dashboardPage= new DashboardPage(driver);
	CartPage cartPage= new CartPage(driver);
	CheckoutPage checkoutPage=new CheckoutPage(driver);
	ConfirmationPage confirmationPage=new ConfirmationPage(driver);
	
//	WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(3));
//	loginPage.goTo();
	loginPage.loginApplication(input.get("email"), input.get("password"));
	
      List<WebElement> products= dashboardPage.getProductList();
	
	dashboardPage.getProductByName(input.get("productName"));
	dashboardPage.addProductToCart(input.get("productName"));
	Thread.sleep(2000);
	Assert.assertTrue(cartPage.verifyCartProducts(input.get("productName")));
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
	String productname = "ZARA COAT 3";
	Assert.assertTrue(ordersPage.verifyOrderDisplayed(productname));
	}
	
	@Test(groups = {"login"})
	public void loginPass() throws IOException
	{
		LoginPage loginPage=launchApplication();
		loginPage.loginApplication("qaonkar4@mailinator.com", "Qa@123456");
		
		
	}
	
	@Test(groups = {"login"})
	public void loginFail() throws IOException
	{
		LoginPage loginPage=launchApplication();
		loginPage.loginApplication("qaonkar4@mailinator.com", "Qa@13456");
		Assert.assertEquals(loginPage.getErrorMessage(),"Incorrect email or password.");
	}

	
	@DataProvider(name = "emailData")
	public Object[][] getData()
	{
		return new Object[][] { {"qaonkar4@mailinator.com","Qa@123456","ZARA COAT 3"},{"qaonkar3@mailinator.com","Qa@123456", "ADIDAS ORIGINAL"}};
	}
	
	@DataProvider(name="hashMapData")
	public Object[][] gethasmapData() throws IOException
	{
	HashMap<String,String>	map=new HashMap<String, String>();
	
	
	 List <HashMap<String, String>>  data=getJsonDataToMap("D:\\Selenium2024\\SeleniumJavaFramework\\src\\test\\java\\qaOnkar\\data\\PurchaseOrder.json");
	return new Object[][] { {data.get(0)},{data.get(1)}};
	}
	
	}


