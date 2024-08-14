package methodClass;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutClass extends BaseClass {
	
	@FindBy(id = "customer-email")
	WebElement emailid;
	
	@FindBy(xpath = "//img[@alt='Loading...']")
	WebElement loading;
	
	@FindBy(name="firstname")
	WebElement firstName;

	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(name="street[0]")
	WebElement street;

	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="region_id")
	WebElement stateDropdown;
	
	@FindBy(name="postcode")
	WebElement postcode;
	
	@FindBy(name="country_id")
	WebElement countryDropdown;
	
	@FindBy(name="telephone")
	WebElement telephone;
	
	@FindBy(xpath = "//input[@value='tablerate_bestway']")
	WebElement zeroShipping;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextBtn;
	
	@FindBy(xpath = "//span[text()='Ship To:']")
	WebElement textShipTo;
	
	@FindBy(xpath = "//div[text()='Vidhi'][1]")
	WebElement actualFName;
	
	@FindBy(id ="customer-email-error")
	WebElement emailErrorMsg;
	
	@FindBy(xpath = "//span[@data-bind='text: errorValidationMessage()']")
	WebElement dispShippingErrorMsg;
	
	
	
	public void enter_email(String email) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(loading)); 
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		
		emailid.sendKeys(email);
		
	}
	
	public void fName(String fname) {
		firstName.sendKeys(fname);
		
	}
	
	public void lName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void streetAddress(String addrs) {
		//move page to centre usin javascript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", street);
		street.sendKeys(addrs);
	}
	
	public void cityName(String cityname) {
		city.sendKeys(cityname);
	}
	
	public void selectState(String state) {
		//for dropdown use select class
		Select s = new Select(stateDropdown);
		s.selectByVisibleText(state);
	}
	
	public void addZipCode(String zip) {
		postcode.sendKeys(zip);
	}
	
	public void addCountry(String country) {
		Select s = new Select(countryDropdown);
		s.selectByVisibleText(country);
	}
	
	public void addPhoneNumber (String number) {
		telephone.sendKeys(number);
	}
	
	public void shippingCharge() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(loading)); 
		zeroShipping.click();
	}
	
	public void nextPage() {
		
		nextBtn.click();
	}
	
	public void paymentPageIsLoaded() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(textShipTo));	}
	
	public void verifyDetail(String fname) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(loading)); 
		String result = actualFName.getText().trim();
		String fresult =result.substring(0,result.indexOf('\n')).trim();
		assertEquals("Name is not matched", fresult , fname);
		
		//screenshot
		TakesScreenshot shot = ((TakesScreenshot)driver);
		//capture screenshot as a file store it as a file
		File file = shot.getScreenshotAs(OutputType.FILE);
		//convert string path into File
		File tempShot = new File(System.getProperty("user.dir") + "\\Image\\abc.png");
		FileUtils.copyFileToDirectory(file, tempShot);
	}
	
	public void verifyErrorMsgs() throws IOException
	{
		ErrorMsgForEmail();
		ErrorMsgForShipping();
	}
	
	public void verifyErrorMsgs(String expectedMsg) {
		ErrorMsgForEmail(expectedMsg);
		
	}
	public void ErrorMsgForEmail() throws IOException
	{
		//System.out.println(emailErrorMsg.getText());
		String displayedErrormsg = emailErrorMsg.getText();
		String expectedMsg = getProjectProp("emailError");
		assertEquals("Incomplete Email entered",displayedErrormsg,expectedMsg);
	}
	
	public void ErrorMsgForEmail(String expectedMsg)
	{
		String displayedErrormsg = emailErrorMsg.getText();
		
		assertEquals("Incomplete Email entered",displayedErrormsg,expectedMsg);
	}
	
	public void ErrorMsgForShipping() throws IOException {
		String dShipErrMsg = dispShippingErrorMsg.getText();
		String expeErrMsg = getProjectProp("shippingError");
		assertEquals("Error msg mismatch",dShipErrMsg,expeErrMsg);
	}
	
	
	
	public void quitDriver() {
		driver.quit();
	}
}
