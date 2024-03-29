package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.zigWheelsHome;
import testBase.BaseClass;

public class TC01_zigWheelsHomeTest extends BaseClass{
	
	
	
	@Test(priority=1,groups={"sanity"})
	public void clickOnNewBikesTest() throws InterruptedException, IOException
	{
		zigWheelsHome zWH = new zigWheelsHome(driver);
		zWH.clickOnNewBikes();
		logger.info("Clicked on New Bikes.");
	}
	
	@Test(priority=2,groups={"sanity"})
	public void clickOnUpcomingBikesTest() throws InterruptedException, IOException
	{
		zigWheelsHome zWH = new zigWheelsHome(driver);
		Assert.assertEquals(zWH.clickOnUpcomingBikes(), "Upcoming Bikes");
		logger.info("Clicked on Upcoming Bikes.");
	}
	
	
	@Test(priority=11,groups={"sanity"})
	public void clickLoginTest() throws IOException
	{
		zigWheelsHome zWH = new zigWheelsHome(driver);
		zWH.clickLogin();
		logger.info("Clicked on Login/SignUp.");
	}
	
	
	@Test(priority=12,groups={"sanity,regression"})
	public void clickGoogleLoginTest()
	{
		zigWheelsHome zWH = new zigWheelsHome(driver);
		zWH.clickGoogleLogin();
		logger.info("Clicked on login with Google.");
	}
	
	
	@Test(priority=13,groups={"sanity,regression"})
	public void switchToLoginWindowTest() throws InterruptedException
	{
		zigWheelsHome zWH = new zigWheelsHome(driver);
		Assert.assertEquals(zWH.switchToLoginWindow(),"Sign in - Google Accounts");
		logger.info("Switched focus to Login window.");
	}
	
}