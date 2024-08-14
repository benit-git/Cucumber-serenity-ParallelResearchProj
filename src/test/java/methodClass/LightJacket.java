package methodClass;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LightJacket extends BaseClass{
	
	//select size and colour
	@FindBy(xpath = "//div[@option-label='XS']")
	WebElement jSizeXS;
		
	@FindBy(xpath = "//div[@option-label='S']")
		WebElement jSizeS;
	
	@FindBy(xpath = "//div[@option-label='M']")
		WebElement jSizeM;
	
	@FindBy(xpath = "//div[@option-label='Purple']")
	WebElement jColorPurple;
	
	@FindBy(xpath = "//span[text()='Add to Cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//a[@class='action showcart']")
	WebElement myCart;
	
	@FindBy(xpath = "//button[@title='Proceed to Checkout']")
	WebElement checkoutBtn;
	
	@FindBy(xpath = "//span[@class='counter qty'][1]")
	WebElement cart;
	
	@FindBy(xpath = "//img[@alt='Loading...']")
	WebElement loading;

	
	public void jacketSize(String jsize) {
		String title = driver.getTitle();
		assertEquals("Olivia 1/4 Zip Light Jacket", title);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
		
		
	switch(jsize) {
	case "XS":
		jSizeXS.click();
		break;
	case "S":	
		jSizeS.click();
		break;
	case "M":
		jSizeM.click();
		break;
	}
	
	}
	
	public void jacketColor(String color) {
		jColorPurple.click();
	}
	
	public void addToCart() {
		JavascriptExecutor js = (JavascriptExecutor) driver; //to scroll till object
		js.executeScript("arguments[0].ScrollIntoView;arguments[0].click();",addToCartBtn);
		
	}
	
	public void goToCart() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(loading)); 
		wait.until(ExpectedConditions.visibilityOf(cart));
		cart.click();
	}
	public void checkout() {
		checkoutBtn.click();
	}
	

}
