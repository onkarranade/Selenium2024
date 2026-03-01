package qaOnkar.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaOnkar.AbstractComponents.AbstractComponent;

public class DashboardPage extends AbstractComponent {

	WebDriver driver;
	WebDriverWait w;
	// By locators as alternative:
	// private By ordersButtonBy = By.xpath("//button[@routerlink='/dashboard/myorders']");
	// private By productsByAlt = By.cssSelector(".mb-3");
	// private By spinnerBy = By.cssSelector(".ng-animating");
	// private By cartButtonBy = By.cssSelector("[routerlink*='/dashboard/cart']");

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// this.w= new WebDriverWait(driver, Duration.ofSeconds(3));
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement OrdersButton;

	@FindBy(css = ".mb-3")

	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By ProductsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	@FindBy(css = "[routerlink*='/dashboard/cart']")
	WebElement cartButton;

	public List<WebElement> getProductList() {
		// if using By locator:
		// waitForElementToAppear(productsByAlt);
		// return driver.findElements(productsByAlt);
		waitForElementToAppear(ProductsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProductToCart(String productName) {

		WebElement prod = getProductByName(productName);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		// alternatively: driver.findElement(cartButtonBy).click();
		cartButton.click();

	}

}
