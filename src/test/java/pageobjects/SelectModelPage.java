package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericUtils;

import java.util.Random;

public class SelectModelPage {

	public WebDriver driver;
	GenericUtils utils;

	By models = By.xpath(".//img[@class='img-thumbnail']");

	public SelectModelPage(WebDriver driver) {
		this.driver = driver;
	}


	public void chooseModel() {
		Random rand = new Random();
		driver.findElements(models).get(rand.nextInt(5)).click();
	}
}
