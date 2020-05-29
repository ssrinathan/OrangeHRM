package hrm;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class TestCase_002_EmployeeDetails extends ProjectSpecificMethods {
	
	@Test
	public void fetchEmployeeDetails() throws InterruptedException
	{
		new LoginPage(driver)
		.enterUserName()
		.enterPassWord()
		.clickLoginButton()
		.checkAccountID()
		.clickPIM()
		.clickEmployeeList()
		.fetchEmployeeDetails()
		.logOut();
	}
}
