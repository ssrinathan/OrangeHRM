package hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase_001_LoginLogout {

	@Test(dataProvider = "userRoles")
	public void loginLogout(String role)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions action = new Actions(driver);
		System.out.println("Browser Launched");
		driver.manage().window().maximize();
		System.out.println("Browser Maximized");
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");
		System.out.println("URL Loaded");
		driver.findElementById("txtUsername").clear();
  		driver.findElementById("txtUsername").sendKeys("admin");
		System.out.println("User Name Entered");
		driver.findElementById("txtPassword").clear();
		driver.findElementById("txtPassword").sendKeys("admin123");
		System.out.println("Password Entered");
		driver.findElementByXPath("//button[contains(text(),'Login as a Different Role')]").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='"+role+"']")));
		driver.findElementByXPath("//a[text()='"+role+"']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("account-name")));
		String accountName = driver.findElementById("account-name").getText();
		System.out.println("Login successful with role as "+accountName);
		action.moveToElement(driver.findElementById("account-name")).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
		driver.findElementById("logoutLink").click();
		driver.close();
	}
	@DataProvider(name="userRoles")
	public String[] userRole()
	{
		String[] userRole= new String[3];
		userRole[0] = "System Administrator";
		userRole[1] = "Administrator";
		userRole[2] = "ESS User";
		return userRole;
	}
}
