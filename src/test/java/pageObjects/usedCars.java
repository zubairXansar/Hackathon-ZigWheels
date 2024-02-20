package pageObjects;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtils;

public class usedCars extends BasePage
{

	public usedCars(WebDriver driver) 
	{
		super(driver);
		
	}
	
	
	String filepath = "C:\\Users\\2303569\\eclipse-workspace\\hackathonProject\\testData\\hack.xlsx";
	
	//locators
	@FindBy(xpath="//div[@class='gsc_thin_scroll']//li/label") 
	List <WebElement> popularModels;
	
	@FindBy(xpath="//a[@class=\"zw i-b mt-10 pt-2 zw-srch-logo\"]") 
	WebElement zigLogo;
	
	@FindBy(xpath="//div[@id='forum_login_div_lg']") 
	WebElement loginButton;
	
	@FindBy(xpath="//a[@class='a']") 
	WebElement scroll2;
	
	
	//verifying elements
		@FindBy(xpath="//span[@class=\"bc-cl\"]") 
		WebElement currentPage;
	
	
	//action methods
	public String verifyLocation() throws IOException
	{
		fluentWait(currentPage);
		screenShot("usedCars");
		return currentPage.getText();
		
	}
	
	public void getPopularModels() throws IOException
	{
		int j = 1;
		scroll(scroll2);
		System.out.println("Popular Models: ");
		for(WebElement model:popularModels) {
		System.out.println(model.getText());
		ExcelUtils.setcelldata(filepath, "Sheet2", j, 0, model.getText());
		j++;
	}
	}
	
	public boolean navigateToHome() throws InterruptedException, IOException
	{
		zigLogo.click();
		Thread.sleep(5000);
		screenShot("backHome");
		return loginButton.isDisplayed();
		
		
	}
	
	
}