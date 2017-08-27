package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ChooseSignMethodPage {
	
	public WebDriver driver;
	public ChooseSignMethodPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By justOthers = By.id("signjustothers");
	By recipientName = By.id("tsm_group_request_recipient_name1");
	By recipientEmail = By.id("tsm_group_request_recipient1");
	By documentTitle = By.id("request_subject");
	By messageForSingers = By.tagName("textarea");
	By requestSignatureButton = By.id("tsm_group_request_submit");
	By uploadFilesButton = By.cssSelector("input[type='file']");
	By prepareDocsForSigningButton = By.cssSelector("a[href*='Prepare docs for signing']");
	
	public WebElement getSignMethodJustOthers() {
		return driver.findElement(justOthers);
	}
	
	public WebElement getRecipientNameField() {
		return driver.findElement(recipientName);
	}
	
	public WebElement getRecipientEmailField() {
		return driver.findElement(recipientEmail);
	}
	
	public WebElement getDocumentTitleField() {
		return driver.findElement(documentTitle);
	}
	
	public WebElement getMessageForSingersField() {
		return driver.findElement(messageForSingers);
	}
	
	public WebElement getRequestSignatureButton() {
		return driver.findElement(requestSignatureButton);
	}
	
	public WebElement getUploadFileButton() {
		return driver.findElement(uploadFilesButton);
	}
	
	public WebElement getPrepareDocsForSigningButton() {
		return driver.findElement(prepareDocsForSigningButton);
	}
	
	public void dissmissOverlay() {
		driver.findElement(By.cssSelector("div[id='onboarding-overlay']")).click();
	}
	
	public void logout() {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.cssSelector("div[class='m-app-topbar--menu']"))).perform();
		builder.moveToElement(driver.findElement(By.linkText("Logout"))).click().perform();
	}
}
