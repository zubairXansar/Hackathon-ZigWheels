package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.googleLogin;

public class TC04_googleLoginTest extends TC03_usedCarsTest{

	
	@Test(priority=14,groups={"sanity,regression"})
	public void emailInputTest()
	{
		googleLogin gL = new googleLogin(driver);
		gL.emailInput();
		logger.info("Entered invalid email input.");
	}
	
	
	@Test(priority=15,groups={"master"})
	public void verifyInputTest() throws IOException
	{
		googleLogin gL = new googleLogin(driver);
		Assert.assertEquals(gL.verifyInput(), true);
		logger.info("Catch invalid input error");
	}
	
}
