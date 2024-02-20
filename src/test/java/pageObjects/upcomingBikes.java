package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtils;

public class upcomingBikes extends BasePage
{

	public upcomingBikes(WebDriver driver) 
	{
		super(driver);
		
	}
	
	String filepath = "C:\\Users\\2303569\\eclipse-workspace\\hackathonProject\\testData\\hack.xlsx";
	
	//locators
	@FindBy(xpath="//select[@id='makeId']") 
	WebElement brandDropdown;
	
	@FindBy(xpath="//a[@data-track-label='model-name']//following-sibling::div[1]")
	List<WebElement> price;
	
	@FindBy(xpath="//span[@class=\"zw-cmn-loadMore\"]")
	WebElement viewMoreButton;
	
	@FindBy(xpath="//ul[@class='mk-row srp_main_div clr']//li[contains(@class,'col-lg-4 txt-c rel modelItem')]")
	List<WebElement> bikeAvailable;
	
	@FindBy(xpath="//a[@data-track-label='model-name']")	
	List<WebElement> modelName;
	
	@FindBy(xpath="//a[@data-track-label='model-name']//following-sibling::div[2]")
	List<WebElement> date;
	
	@FindBy(xpath="//a[@class='c-p'][contains(text(),'Used Cars')]")
	WebElement usedCarsLink;
	
	@FindBy(xpath="//li/span[contains(text(),\"Chennai\")]")
	WebElement locChennai;
	
	@FindBy(xpath="//h1[@class=\"mt-0 pt-2 pull-left zm-cmn-colorBlack\"]")
	WebElement scroll1;
	
	
	
	
//	//bikes
//	
//	@FindBy(xpath="//div[@class='zw-con p-0 sl-card']/div[3]/a") List <WebElement> bikeTitleEle;
//	@FindBy(xpath="//div[@class='zw-con p-0 sl-card']/div[3]/div[1]") List <WebElement> bikePriceEle;
//
//	//list
//	@FindBy(xpath="//li[@class='col-lg-4 txt-c rel modelItem ']") List <WebElement> priceDataEle;
		
	
	
	//verifying elements
	@FindBy(xpath="//span[@class=\"bc-cl\"]") 
	WebElement currentPage;
	
	
	
	//action methods
	
	public void filterBikes() throws InterruptedException, IOException{
		
		scroll(scroll1);
		screenShot("Upcoming Honda Bikes");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", viewMoreButton);
		Thread.sleep(2000);
		int j=2;
		for(int i=0;i<modelName.size();i++) 
			{
					if(Integer.parseInt(bikeAvailable.get(i).getAttribute("data-price"))<400000 )
								{	
									System.out.println(modelName.get(i).getText());
									ExcelUtils.setcelldata(filepath, "Sheet1", j, 0, modelName.get(i).getText());
									
									System.out.println(price.get(i).getText());
									ExcelUtils.setcelldata(filepath, "Sheet1", j, 1, price.get(i).getText());
									
									System.out.println(date.get(i).getText());
									ExcelUtils.setcelldata(filepath, "Sheet1", j, 2, date.get(i).getText());
									
									System.out.println("=================================");
									j++;

								}
					else {
							continue;
						 }
			}
	}
	
	public String selectManufacturer() throws IOException
	{
		Select drp=new Select(brandDropdown);
		drp.selectByVisibleText("Honda");
		screenShot("dropdown");
		fluentWait(currentPage);
		return currentPage.getText();
		
	}
	
	
	public void clickUsedCars()
	{
		Actions ac= new Actions(driver);
		ac.moveToElement(usedCarsLink).build().perform();
		
	}
	
	public void selectLocation() throws InterruptedException
	{
		locChennai.click();
		Thread.sleep(3000);
		
	}	
		
}
