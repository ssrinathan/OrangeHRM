package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	
	RemoteWebDriver driver;
	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public LoginPage enterUserName()
	{
		driver.findElementById("txtUsername").clear();
		driver.findElementById("txtUsername").sendKeys("admin");
		System.out.println("User Name Entered");
		return this;
	}
	
	public LoginPage enterPassWord()
	{
		driver.findElementById("txtPassword").clear();
		driver.findElementById("txtPassword").sendKeys("admin123");
		System.out.println("Password Entered");
		return this;
	}
	
	public LandingPage clickLoginButton()
	{
		driver.findElementById("btnLogin").click();
		System.out.println("Login Button clicked");
		return new LandingPage(driver);
	}
}
