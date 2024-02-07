package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class zigWheelsHome extends BasePage
{

	public zigWheelsHome(WebDriver driver) 
	{
		super(driver);
	}
	
	
	//locators
	@FindBy(linkText="New Bikes") 
	WebElement newBikesLink;
	
	@FindBy(xpath="//span[text()='Upcoming Bikes']") 
	WebElement upcomingBikes;
	
	@FindBy(xpath="//div[@id=\"des_lIcon\"]") 
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class=\"lgn-sc c-p txt-l pl-30 pr-30 googleSignIn\"]") 
	WebElement googleLogin;
	
	
	//verifying elements
	@FindBy(xpath="//span[@class=\"bc-cl\"]") 
	WebElement currentPage;
	
	
	//action methods
	public void clickOnNewBikes() throws InterruptedException, IOException
	{	
		screenShot("zigwheelsHome");
		fluentWait(newBikesLink);
	
		Actions ac= new Actions(driver);
		ac.moveToElement(newBikesLink).build().perform();

		Thread.sleep(2000);
		}
	
	
	public String clickOnUpcomingBikes()
	{
		upcomingBikes.click();
		fluentWait(currentPage);
		
		return currentPage.getText();
	}
	
	
	public void clickLogin() throws IOException
	{
		loginButton.click();
		screenShot("loginPage");
	}
	
	public void clickGoogleLogin()
	{
		googleLogin.click();
	}
	
	
	public String switchToLoginWindow() throws InterruptedException
	{
		Set <String> allWindowHandles= driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(allWindowHandles);
		driver.switchTo().window(listHandles.get(1));
		
		Thread.sleep(3000);
		
		return driver.getTitle();
	}
	

	
	
}
			
			
			
			


