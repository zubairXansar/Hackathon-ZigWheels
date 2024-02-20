package pageObjects;
 
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
 
public class BasePage {
	WebDriver driver;
	WebElement srcElement;
	String ss;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void screenShot(String ss) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("C:\\Users\\2303569\\eclipse-workspace\\hackathonProject\\screenshots\\MyScreenShots\\"+ss+".png");
		FileUtils.copyFile(src, trg);
	}
	
	public void scroll(WebElement toElement)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", toElement);
	}

	
	
	public void fluentWait(WebElement fluentElement)
	{
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver);
		fluent.withTimeout(Duration.ofSeconds(10));
		fluent.pollingEvery(Duration.ofSeconds(3));
		fluent.ignoring(NoSuchElementException.class);
		
		fluent.until(ExpectedConditions.visibilityOf(fluentElement));
		
	}
	
 
}
