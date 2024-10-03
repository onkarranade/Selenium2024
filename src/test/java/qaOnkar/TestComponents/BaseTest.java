package qaOnkar.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import qaOnkar.pageobjects.LoginPage;

public class BaseTest {

	public WebDriver driver;
	
	public LoginPage loginPage;
	public WebDriver initializeDriver() throws IOException
	{
		
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Selenium2024\\SeleniumJavaFramework\\src\\main\\java\\qaOnkar\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
		} else if (browserName.equalsIgnoreCase("firefox")) {
			
			//fireforx initialize
			
		}
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	public LoginPage launchApplication() throws IOException
	{
		WebDriver driver = initializeDriver();
		 loginPage=new LoginPage(driver);
		loginPage.goTo();
		return loginPage;
		
	}
	
	@AfterSuite
	public void tearDown()
{
		driver.quit();
	}
}


