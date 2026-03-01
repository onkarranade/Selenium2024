package qaOnkar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qaOnkar.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".hero-primary")
	WebElement confirmtext;

	@FindBy(css = "label[class='ng-star-inserted']")
	WebElement orderID;

	By text = By.cssSelector(".hero-primary");
	// alternative By locators:
	// private By confirmTextBy = By.cssSelector(".hero-primary");
	// private By orderIdBy = By.cssSelector("label[class='ng-star-inserted']");

	public String confirmText() {
		// alt example:
		// waitForElementToAppear(confirmTextBy);
		// return driver.findElement(confirmTextBy).getText();
		waitForElementToAppear(text);
		return confirmtext.getText();
	}

	public String getOrderID() {
		// String ordernumber = driver.findElement(orderIdBy).getText();
		String ordernumber = orderID.getText();
		return ordernumber;
	}
}
