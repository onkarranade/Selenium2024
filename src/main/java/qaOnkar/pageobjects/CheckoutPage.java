package qaOnkar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qaOnkar.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement resultCountry;
	
	@FindBy(css = ".action__submit")
	WebElement Submit;
	
	
	By result=By.cssSelector(".ta-results");
	
	public void selectCountry()
	{
		country.sendKeys("india");
		waitForElementToAppear(result);
		resultCountry.click();
	}
	
	public void Submit()
	{
		Submit.click();
	}
}
