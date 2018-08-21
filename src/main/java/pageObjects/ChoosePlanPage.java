package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChoosePlanPage {
	public WebDriver driver;

	public ChoosePlanPage(WebDriver driver) {
		this.driver = driver;
	}

	By individualPlanIcon = By.xpath("//div[@class='team-size-level'][1]");
	By freePlanLink = By.cssSelector("a[href*='chooseFreeOrEnterpriseSignupPlan']");

	public WebElement getIndividualPlan() {
		return driver.findElement(individualPlanIcon);
	}

	public WebElement getFreePlanLink() {
		return driver.findElement(freePlanLink);
	}

}
