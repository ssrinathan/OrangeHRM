package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificMethods {

	public ChromeDriver driver;
	@BeforeMethod
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");
	}

	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
