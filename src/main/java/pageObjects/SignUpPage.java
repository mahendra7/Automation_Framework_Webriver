package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
	
	public WebDriver driver;
	
	By emailAddress = By.name("signUp.email");
	By createAccountButton = By.cssSelector("button[type='submit']");
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getInputEmailAddress() {
		return driver.findElement(emailAddress);
	}
	
	public WebElement getCreateAccountButton() {
		return driver.findElement(createAccountButton);
	}

}
