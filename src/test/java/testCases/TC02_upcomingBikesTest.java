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
	}
	
	@Test(priority=4,groups={"regression"})
	public void filterBikesTest() throws InterruptedException, IOException
	{
		 upcomingBikes uB = new upcomingBikes(driver);
		uB.filterBikes();
	}
	
	
	@Test(priority=6,groups={"regression"})
	public void clickUsedCarsTest()
	{
		upcomingBikes uB = new upcomingBikes(driver);
		uB.clickUsedCars();
	}
	
	@Test(priority=7,groups={"regression"})
	public void selectLocationTest() throws InterruptedException
	{
		upcomingBikes uB = new upcomingBikes(driver);
		uB.selectLocation();
	}
	

}
