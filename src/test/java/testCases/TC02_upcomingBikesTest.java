package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.upcomingBikes;

public class TC02_upcomingBikesTest extends TC01_zigWheelsHomeTest{
	
	
	
	@Test(priority=3,groups={"sanity,regression"})
	public void selectManufracturerTest() throws IOException
	{
		upcomingBikes uB = new  upcomingBikes(driver);
		Assert.assertEquals(uB.selectManufacturer(), "Honda Bikes");
		logger.info("Selected 'Honda' from dropdown.");
	}
	
	@Test(priority=4,groups={"regression"})
	public void filterBikesTest() throws InterruptedException, IOException
	{
		 upcomingBikes uB = new upcomingBikes(driver);
		uB.filterBikes();
		logger.info("Upcoming Bike details filtered for price under 4 lakhs.");
	}
	
	
	@Test(priority=6,groups={"regression"})
	public void clickUsedCarsTest()
	{
		upcomingBikes uB = new upcomingBikes(driver);
		uB.clickUsedCars();
		logger.info("Clicked on used cars");
	}
	
	@Test(priority=7,groups={"regression"})
	public void selectLocationTest() throws InterruptedException
	{
		upcomingBikes uB = new upcomingBikes(driver);
		uB.selectLocation();
		logger.info("Clicked on Chennai location.");
	}
	

}
