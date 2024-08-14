package methodClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;

public class BaseClass {

	static WebDriver driver;
	public static Scenario scene;

	public String getProjectProp(String key) throws IOException {
		FileReader reader = new FileReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\ProjectProperties\\errorMsg.properties");
		Properties p = new Properties();
		p.load(reader);
		return p.get(key).toString();
	}

	public void screensht(Scenario scenario) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		//File src = ts.getScreenshotAs(OutputType.FILE);
		byte[] srcfile = ts.getScreenshotAs(OutputType.BYTES);
		scenario.embed(srcfile, "image/png");
	}
	
	
}