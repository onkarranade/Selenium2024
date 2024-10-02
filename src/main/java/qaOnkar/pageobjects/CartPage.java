package qaOnkar.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qaOnkar.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	
	@FindBy(css = ".cartSection h3")
private	List<WebElement> cartProducts;
	
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	WebElement checkoutButton;
	
	public boolean verifyCartProducts(String productName)
	{
		//List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		
	//	System.out.println(cartProducts.get(0).getText());
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	public void checkOut()
	{
		checkoutButton.click();
	}
}


