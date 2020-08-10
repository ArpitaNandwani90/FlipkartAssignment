package pages;

import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;
import util.ReusableMethods;


public class CartPage extends TestBase{
	
	@FindBy(xpath = "//a[text()='Help Center']")
	WebElement helpCenterLink;
	
	@FindBy(xpath = "//p[contains(text(),'Preorder')]")
	WebElement topicLink;
	
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yesLink;
	
	@FindBy(xpath = "//span[text()='Place Order']")
	WebElement placeOrderBtn;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String clickHelpCenter() {
		helpCenterLink.click();
		ReusableMethods.waitForElement(helpCenterLink);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1)); //switching to HelpCenter Window
		String currentwindow = driver.getTitle();
		ReusableMethods.waitForElement(topicLink);
		topicLink.click();
		yesLink.click();
		driver.switchTo().window(newTab.get(0));
		return currentwindow;
			
	}
	
	public String placeOrder() {
		
		placeOrderBtn.click();
		String currenturl = driver.getCurrentUrl();
		return currenturl;
	}

}
