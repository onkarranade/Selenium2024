package qaOnkar.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qaOnkar.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent{
	
	
	WebDriver driver;
	public OrdersPage(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
		//this.w= new WebDriverWait(driver, Duration.ofSeconds(3));
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css = "tr td:nth-child(3)")
	public List<WebElement> ProductNames;
	public boolean  verifyOrderDisplayed(String productname)
	{
		Boolean match=ProductNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
		System.out.println(match);
		return match;
	}

	
}
