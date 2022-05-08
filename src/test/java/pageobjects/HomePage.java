package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	By login = By.xpath(".//a[@href='/']");
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void launchHomePage(){
		driver.get("https://buggy.justtestit.org");
	}

	public void clickHomePageLogo(){
		driver.findElement(login).click();
	}
	
}
