package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import util.ReusableMethods;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//span[text()='TVs & Appliances']")
	WebElement tv_Appliances;
	
	@FindBy(xpath = "//a[text()='48 - 55']")
	WebElement screenSize;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public TelevisionPage selectTelevision() {
		Actions action = new Actions(driver);
		action.moveToElement(tv_Appliances).build().perform();
		ReusableMethods.waitForElement(screenSize);
		screenSize.click();
		return new TelevisionPage();
	}

}
