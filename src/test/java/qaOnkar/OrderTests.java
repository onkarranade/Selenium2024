package qaOnkar;

import java.io.IOException;

import org.testng.annotations.Test;

import qaOnkar.TestComponents.BaseTest;
import qaOnkar.pageobjects.DashboardPage;
import qaOnkar.pageobjects.LoginPage;

public class OrderTests extends BaseTest {

	@Test(groups = { "sample" })

	public void sampleTest() throws IOException {
		LoginPage loginPage = launchApplication();
		loginPage.loginApplication("qaonkar4@mailinator.com", "Qa@123456");
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.goToOrdersPage();
		driver.quit();

	}

	@Test

	public void sampleTest1() throws IOException {
		LoginPage loginPage = launchApplication();
		loginPage.loginApplication("qaonkar4@mailinator.com", "Qa@123456");
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.goToOrdersPage();
		driver.quit();
	}
}
