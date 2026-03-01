package qaOnkar.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qaOnkar.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {

	WebDriver driver;
	// without @FindBy (By locators can be declared at class level):
	// private By userEmailBy = By.id("userEmail");
	// private By userPasswordBy = By.id("userPassword");
	// private By loginBy = By.id("login");
	// private By errorFlyoutBy = By.cssSelector("[class*='flyInOut']");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail =driver.findElement(By.id("userEmail"));

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement login;

	@FindBy(css = "[class*='flyInOut']")
	WebElement errorFlyout;

	public void loginApplication(String email, String password) {
		// example using the By locators instead of @FindBy elements:
		// driver.findElement(userEmailBy).sendKeys(email);
		// driver.findElement(userPasswordBy).sendKeys(password);
		// driver.findElement(loginBy).click();
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
	}

	public void goTo()

	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErrorMessage() {

		// alternative example:
		// waitForWebElementToAppear(driver.findElement(errorFlyoutBy));
		// return driver.findElement(errorFlyoutBy).getText();
		waitForWebElementToAppear(errorFlyout);
		return errorFlyout.getText();
	}

}
