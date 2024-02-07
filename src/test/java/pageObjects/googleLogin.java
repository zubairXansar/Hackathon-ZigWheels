package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class googleLogin extends BasePage
{

	public googleLogin(WebDriver driver) 
	{
		super(driver);
		
	}
	
	
	//locators
	@FindBy(xpath="//input[@id=\"identifierId\"]") 
	WebElement emailInput;
	
	@FindBy(xpath="//span[contains(text(),'Next')]") 
	WebElement nextButton;
	
	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae']") 
	WebElement inputWarning;
	
	
	
	//action methods
	public void emailInput() 
	{
		emailInput.sendKeys("jgdjfkgjcjgvk");
	}
	
	
	public boolean verifyInput() throws IOException 
	{
		nextButton.click();
		System.out.println("=================================");
		System.out.println();
		System.out.println("Warning message: "+inputWarning.getText());
		screenShot("inputWarning");
		return inputWarning.isDisplayed();
	}
	
	
	
}
