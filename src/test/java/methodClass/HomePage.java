package methodClass;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import dev.failsafe.internal.util.Assert;

public class HomePage extends BaseClass {

	public HomePage() {

	}

	// list the id/xpath of all elements which are to be searched
	@FindBy(xpath = "//span[contains(text(),'Women')]/ancestor::a/span")
	WebElement womenDropDown;

	@FindBy(xpath = "//span[contains(text(),'Tops')][1]")
	WebElement womensTops;

	@FindBy(xpath = "//span[contains(text(),'Jackets')][1]")
	WebElement womensJacket;

	public void launch_site(String site) {

		String browserName = System.getProperty("brName");
		if (browserName == null) {
			browserName = " ";
		}
		switch (browserName) {
		case "edge":
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\DriverRepo\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "chrome":
		default:
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\DriverRepo\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		System.out.println(driver.getClass());
		driver.manage().window().maximize();
		driver.get(site);
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	// add method for title
	public void homeTitle(String t) {

		String title = driver.getTitle();
		assertEquals(t, title);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public void select_women_section() {
		// hover over womens section tab
		Actions act = new Actions(driver);
		act.moveToElement(womenDropDown).build().perform();
		screensht(scene);

	}

	public void select_tops() {
		Actions act = new Actions(driver);
		act.moveToElement(womensTops).build().perform();

	}

	public void select_jackets() {
		womensJacket.click();
	}
}
