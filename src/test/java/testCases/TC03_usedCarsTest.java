package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.usedCars;

public class TC03_usedCarsTest extends TC02_upcomingBikesTest{
	
	
	@Test(priority=8,groups={"sanity,regression"})
	public void verifyLocTest() throws IOException
	{
		usedCars uC = new usedCars(driver);
		Assert.assertEquals(uC.verifyLocation(),"Chennai");
	}
	
	
	@Test(priority=9,groups={"regression"})
	public void getPopularModelsTest() throws IOException
	{
		usedCars uC = new usedCars(driver);
		uC.getPopularModels();
	}
	
	
	@Test(priority=10,groups={"regression"})
	public void navigateToHomeTest() throws InterruptedException, IOException
	{
		usedCars uC = new usedCars(driver);
		Assert.assertEquals(uC.navigateToHome(),true);
	}

}
