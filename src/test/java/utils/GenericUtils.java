package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils extends TestBase{

	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void click(By element) {
		driver.findElement(element).click();
	}
	
	public void sendText(By element, String textToEnter) {
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(textToEnter);
	}
	
	public String getText(By element) {
		return driver.findElement(element).getText().trim();
	}

	public  void waitForElementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
 
	
}
