package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {


	By name = By.name("login");
	By password = By.name("password");
	By loginGreeting = By.xpath(".//span[@class='nav-link disabled']");
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginAs(String _userName, String _password){
		driver.findElement(name).sendKeys(_userName);
		driver.findElement(password).sendKeys(_password);
	}

	public void validateWebsiteloggedinState() {
		assert(driver.findElement(loginGreeting).getText().contains("Hi"));
	}
}

