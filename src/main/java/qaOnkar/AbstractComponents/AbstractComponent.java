package qaOnkar.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaOnkar.pageobjects.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		
		this.driver=driver;
	
	}
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	
	public void waitForElementToAppear(By findBy) {
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));   
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
		
	    }
	
	public void waitForElementToDisappear(WebElement ele) {
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));   
	    wait.until(ExpectedConditions.invisibilityOf(ele));
	    }
	
	public OrdersPage goToOrdersPage()
	{
		orderHeader.click();
		OrdersPage ordersPage=new OrdersPage(driver);
		return ordersPage;
		
	}


}
