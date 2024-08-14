package methodClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class JacketsWomen extends BaseClass{
	
	@FindBy(xpath = "//li[@class='item product product-item'][1]")
	WebElement fJacket;
	
	public void select_1st_jacket() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
		fJacket.click();
	}

}
