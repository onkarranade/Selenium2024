package qaOnkar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qaOnkar.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmtext;
	
	@FindBy(css = "label[class='ng-star-inserted']")
	WebElement orderID;
	
	By text = By.cssSelector(".hero-primary");
	
	public String confirmText()
	{
		waitForElementToAppear(text);
		 return confirmtext.getText();
	}
	
	public String getOrderID()
	{
		String ordernumber =orderID.getText();
		return ordernumber;
	}
}
