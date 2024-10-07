package qaOnkar.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		
		
		//read json to string
		String jsonContent=FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
	
	//String to hasmap with jackson bind
	ObjectMapper mapper=new ObjectMapper();
	
	List<HashMap<String, String>> data=mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>() {} );
	return data;
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


