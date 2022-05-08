package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.GenericUtils;

public class RegistrationPage {

	public WebDriver driver;
	GenericUtils utils;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		utils = new GenericUtils(driver);
	}

	By userName = By.id("username");
	By firstName = By.id("firstName");
	By lastName = By.id("lastName");
	By password = By.id("password");
	By confirmpassword = By.id(("confirmPassword"));
	By register = By.xpath("//button[contains(@class,'btn-default')][@type='submit']");
	By registrationSuccess = By.xpath("//div[contains(@class,'alert-success')]");

	public void enterLogin(String loginEmail) {
		
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys(loginEmail);
	}

	public void enterfirstName(String fName) {
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(fName);
	}

	public void enterlastName(String lName) {
		//utils.sendText(lastName,lName);
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(lName);
	}

	public void enterPassword(String pwd) {
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(pwd);
		utils.sendText(password,pwd);
	}

	public void enterConfirmPassword(String cpwd) {
		driver.findElement(confirmpassword).clear();
		driver.findElement(confirmpassword).sendKeys(cpwd);
	}
	
	public void clickRegister() {
		driver.findElement(register).click();
	}

	public void validateRegistrationSuccess(){
		utils.waitForElementVisibility(driver.findElement(registrationSuccess));
		Assert.assertTrue(driver.findElement(registrationSuccess).isDisplayed());

	}

}
