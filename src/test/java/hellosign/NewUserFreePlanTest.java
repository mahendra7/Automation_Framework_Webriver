package hellosign;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.github.javafaker.Faker;
import pageObjects.ChoosePlanPage;
import pageObjects.HomePage;
import pageObjects.SignUpPage;
import pageObjects.eSignaturePage;
import resources.base;
import org.monte.screenrecorder.ScreenRecorder;
import org.monte.media.math.Rational;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.*;
import java.awt.*;
import java.io.File;
import java.util.List;


public class NewUserFreePlanTest extends base {
	private static ScreenRecorder screenRecorder;
	
	@BeforeTest
	public void testSetup() throws IOException, AWTException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		
		// Create a instance of GraphicsConfiguration to get the Graphics configuration
				// of the Screen. This is needed for ScreenRecorder class.
				GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
						.getDefaultConfiguration();

				// Create a instance of ScreenRecorder with the required configurations
				screenRecorder = new ScreenRecorder(gc, new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
						new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
								CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, (int) 24, FrameRateKey,
								Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, (int) (15 * 60)),
						new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
						null);

				screenRecorder.start();
	}

	@Test(dataProvider = "getData")
	public void freePlanSingupTest(String singUpEmailId, String firstName, String lastName, String jobTitle,
			String companyName) throws IOException {

		driver.get(prop.getProperty("url"));
		HomePage homepage = new HomePage(driver);
		homepage.getSignUpLink().click();

		SignUpPage singnuppage = new SignUpPage(driver);
		singnuppage.getInputEmailAddress().sendKeys(singUpEmailId);
		singnuppage.getCreateAccountButton().click();

		ChoosePlanPage chooseplanpage = new ChoosePlanPage(driver);
		chooseplanpage.getIndividualPlan().click();
		chooseplanpage.getFreePlanLink().click();

		eSignaturePage signaturepage = new eSignaturePage(driver);
		signaturepage.getFirstNameField().sendKeys(firstName);
		signaturepage.getLastNameField().sendKeys(lastName);
		signaturepage.getJobTitleField().sendKeys(jobTitle);
		signaturepage.selectDepartment(prop.getProperty("departmentName"));
		signaturepage.getCompanyNameField().sendKeys(companyName);
		signaturepage.selectIndustry(prop.getProperty("industryName"));
		signaturepage.selectUseCase(prop.getProperty("usecaseName"));
		signaturepage.getDoneButton().click();

		signaturepage.dissmissOverlay();
		signaturepage.logout();

	}

	@AfterTest
	public void teardown() throws IOException {
		driver.close();
		driver = null;
		screenRecorder.stop();
		List<File> createdMovieFiles = screenRecorder.getCreatedMovieFiles();
		for (File movie : createdMovieFiles) {
			System.out.println("New movie created: " + movie.getAbsolutePath());
		}
	}
	
	@DataProvider
	public Object[][] getData() {
		// Object[i][j]
		// i = number of times you want the test to run.
		// j = number of different data parameters for each run.
		// so to run 2 times with 5 data parameters use Object[2][5].

		Object[][] data = new Object[2][5];

		Faker faker = new Faker();
		String firstName1 = faker.name().firstName();
		String lastName1 = faker.name().lastName();

		String firstName2 = faker.name().firstName();
		String lastName2 = faker.name().lastName();

		data[0][0] = firstName1 + "." + lastName1 + "@gmail.com";
		data[0][1] = firstName1;
		data[0][2] = lastName1;
		data[0][3] = faker.company().profession();
		data[0][4] = faker.company().name();

		data[1][0] = firstName2 + "." + lastName2 + "@gmail.com";
		data[1][1] = firstName2;
		data[1][2] = lastName2;
		data[1][3] = faker.company().profession();
		data[1][4] = faker.company().name();

		return data;
	}

}
