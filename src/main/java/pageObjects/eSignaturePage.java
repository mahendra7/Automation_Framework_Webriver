package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class eSignaturePage {

	public WebDriver driver;

	public eSignaturePage(WebDriver driver) {
		this.driver = driver;
	}

	By collectInfoMoalHeader = By.className("m-collect-info-modal--header");
	By firstName = By.cssSelector("input[placeholder='First Name']");
	By lastName = By.cssSelector("input[placeholder='Last Name']");
	By jobTitle = By.cssSelector("input[placeholder='Job Title']");
	By companyName = By.cssSelector("input[placeholder='Company Name']");
	By doneButton = By.cssSelector("button[type='submit']");
	By departmentSelect = By.name("collect[department]");
	By industrySelect = By.name("collect[industry]");
	By useCaseSelect = By.name("collect[use_case]");
	By overLay = By.cssSelector("div[id='onboarding-overlay']");

	public WebElement getCollectionInfoModalHeader() {
		return driver.findElement(collectInfoMoalHeader);
	}

	public WebElement getFirstNameField() {
		return driver.findElement(firstName);
	}

	public WebElement getLastNameField() {
		return driver.findElement(lastName);
	}

	public WebElement getJobTitleField() {
		return driver.findElement(jobTitle);
	}

	public WebElement getCompanyNameField() {
		return driver.findElement(companyName);
	}

	public WebElement getDoneButton() {
		return driver.findElement(doneButton);
	}

	public void selectDepartment(String departmentName) {
		Select dept = new Select(driver.findElement(departmentSelect));
		dept.selectByVisibleText(departmentName);
	}

	public void selectIndustry(String industryName) {
		Select industry = new Select(driver.findElement(industrySelect));
		industry.selectByVisibleText(industryName);
	}

	public void selectUseCase(String useCaseName) {
		Select useCase = new Select(driver.findElement(useCaseSelect));
		useCase.selectByVisibleText(useCaseName);
	}
	
	public void dissmissOverlay() {
		driver.findElement(overLay).click();
	}
	
	public void logout() {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.cssSelector("span[class='m-app-topbar--menu--title--icon']"))).perform();
		builder.moveToElement(driver.findElement(By.linkText("Logout"))).click().perform();
	}

}
