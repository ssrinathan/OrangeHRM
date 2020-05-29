package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethods;

public class EmployeeListPage extends ProjectSpecificMethods{

	RemoteWebDriver driver;
	WebDriverWait wait;

	public EmployeeListPage(RemoteWebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	public EmployeeListPage fetchEmployeeDetails() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='employeeListTable']//tr[1]/td")));
		List<WebElement> tableValue = driver.findElementsByXPath("//table[@id='employeeListTable']//tr[1]/td");
		System.out.println("Below values fetched from the Employee Table"+'\t');
		for (int i = 0; i < tableValue.size(); i++) 
		{
			System.out.print(tableValue.get(i).getText()+"\t");
		}
		return this;
	}

	public EmployeeListPage logOut()
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElementById("account-name")).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
		driver.findElementById("logoutLink").click();
		System.out.println("Logged out of the application successfully");
		return this;
	}
}
