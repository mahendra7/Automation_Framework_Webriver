package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By signUp = By.cssSelector("a[href*=signUp");
	By logIn = By.cssSelector("a[href*='logIn']");

	public WebElement getSignUpLink() {
		return driver.findElement(signUp);
	}

	public WebElement getLoginLink() {
		return driver.findElement(logIn);
	}

}
