package qaOnkar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qaOnkar.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement resultCountry;

	@FindBy(css = ".action__submit")
	WebElement Submit;

	By result = By.cssSelector(".ta-results");
	// alternative By locators:
	// private By countryInputBy = By.cssSelector("input[placeholder='Select Country']");
	// private By resultCountryBy = By.xpath("//button[contains(@class,'ta-item')][2]");
	// private By submitBy = By.cssSelector(".action__submit");

	public void selectCountry(String countryName) {
		// example using By locator:
		// driver.findElement(countryInputBy).sendKeys(countryName);
		// waitForElementToAppear(result);
		// driver.findElement(resultCountryBy).click();
		country.sendKeys(countryName);
		waitForElementToAppear(result);
		resultCountry.click();
	}

	public void Submit() {
		// driver.findElement(submitBy).click();
		Submit.click();
	}
}
