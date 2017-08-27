package hellosign;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import pageObjects.ChoosePlanPage;
import pageObjects.ChooseSignMethodPage;
import pageObjects.LandingPage;
import pageObjects.SignUpPage;
import pageObjects.eSignaturePage;
import resources.base;

public class NewUserFreePlanTest extends base{
	
	@BeforeTest
	public void testSetup() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="getData")
	public void landingPageTest(String singUpEmailId, String firstName, String lastName, String jobTitle, String companyName) throws IOException {
		
		driver.get(prop.getProperty("url"));
		LandingPage landingpage = new LandingPage(driver);
		landingpage.getSignUpLink().click();
		
		SignUpPage singnuppage = new SignUpPage(driver);
		singnuppage.getInputEmailAddress().sendKeys(singUpEmailId);
		singnuppage.getCreateAccountButton().click();
		
		//String signUpEmailAddress = faker.internet().emailAddress();
		System.out.println(singUpEmailId);
		
		ChoosePlanPage chooseplanpage = new ChoosePlanPage(driver);
		chooseplanpage.getIndividualPlan().click();
		chooseplanpage.getFreePlanLink().click();
		
		eSignaturePage signaturepage = new eSignaturePage(driver);
		//String modal = signaturepage.getCollectionInfoModalHeader().getText();
		//System.out.println("Modal Text: " + modal);
		signaturepage.getFirstNameField().sendKeys(firstName);
		signaturepage.getLastNameField().sendKeys(lastName);
		signaturepage.getJobTitleField().sendKeys(jobTitle);
		signaturepage.selectDepartment(prop.getProperty("departmentName"));
		signaturepage.getCompanyNameField().sendKeys(companyName);
		signaturepage.selectIndustry(prop.getProperty("industryName"));
		signaturepage.selectUseCase(prop.getProperty("usecaseName"));
		signaturepage.getDoneButton().click();
		
		ChooseSignMethodPage signmethodpage = new ChooseSignMethodPage(driver);
		signmethodpage.dissmissOverlay();
		signmethodpage.logout();
		
		/*Should be a different test by itself.
		ChooseSignMethodPage signmethodpage = new ChooseSignMethodPage(driver);
		//upload File With Send Keys
		signmethodpage.getUploadFileButton().sendKeys("/Users/mahendraramesh/Desktop/automation/src/main/java/resources/Test-Hello-Sign.pdf");
		signmethodpage.getRecipientNameField().sendKeys("Ramesh");
		signmethodpage.getRecipientEmailField().sendKeys("mramesh@syr.edu");
		signmethodpage.getDocumentTitleField().sendKeys("Please Sign the Doc");
		signmethodpage.getMessageForSingersField().sendKeys("Thank you for signing the Doc");
		signmethodpage.getRequestSignatureButton().click();*/
	}
	
	@AfterTest
	public void teardown()
	{	
		driver.close();
		driver=null;	
	}
	
	@DataProvider
	public Object[][] getData() {
		//Object[i][j] 
		// i = number of times you want the test to run.
		// j = number of different data values per run.
		// so to run 2 times with 5 data value use Object[2][5].
		
		Object[][] data = new Object[2][5]; 

		Faker faker = new Faker();
		String firstName1 = faker.name().firstName();
		String lastName1 = faker.name().lastName();
		
		String firstName2 = faker.name().firstName();
		String lastName2 = faker.name().lastName();
		 
		data[0][0] = firstName1+"."+lastName1+"@gmail.com";;
		data[0][1] = firstName1;
		data[0][2] = lastName1;
		data[0][3] = faker.company().profession();
		data[0][4] = faker.company().name();
		
		data[1][0] = firstName2+"."+lastName2+"@gmail.com";;
		data[1][1] = firstName2;
		data[1][2] = lastName2;
		data[1][3] = faker.company().profession();
		data[1][4] = faker.company().name();
		
		return data;
	}
	

}
