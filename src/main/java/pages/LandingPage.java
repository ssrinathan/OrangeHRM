package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.ProjectSpecificMethods;

public class LandingPage extends ProjectSpecificMethods {
	RemoteWebDriver driver;
	public LandingPage(RemoteWebDriver driver) {
	this.driver = driver;
	}
	

	public LandingPage checkAccountID()
	{
		String accountName = driver.findElementById("account-name").getText();
		System.out.println("Login successful with role as "+accountName);
		return this;
	}
	
	public LandingPage clickPIM()
	{
		driver.findElementByXPath("//span[text()='PIM']").click();
		System.out.println("PIM link clicked");
		return this;
	}
	
	public EmployeeListPage clickEmployeeList()
	{
		driver.findElementByXPath("//span[text()='Employee List']").click();
		System.out.println("Employee List link clicked");
		return new EmployeeListPage(driver);
	}
}
