package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericUtils;

public class LogOutPage {

	
	public WebDriver driver;
	GenericUtils utils;
	
	public LogOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	By logout = By.xpath("//a[contains(@href,'Logout')]");
	
	private void clickLogOut() {
		utils.click(logout);
	}
	
}
