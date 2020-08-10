package pages;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import util.Constants;
import util.ReusableMethods;

public class TelevisionPage extends TestBase{
	
	@FindBy(xpath = "//div[@class='_1qKb_B']//select")
	WebElement startPrice;
	
	@FindBy(xpath = "//div[@class='_1YoBfV']//select")
	WebElement endPrice;
	
	@FindBy(xpath = "//div[text()='Resolution']")
	WebElement resolution;
	
	@FindBy(xpath = "//div[text()='Ultra HD (4K)']//preceding-sibling::div")
	WebElement ultraHDchkbx;
	
	@FindBy(xpath = "//h1[text()='Televisions']//following-sibling::span")
	WebElement noOfProducts;
	
	@FindBy(xpath = "//span[text()='Add to Compare']")
	List<WebElement> televisionList;
	
	@FindBy(xpath = "//span[text()='COMPARE']")
	WebElement compareBtn;
	
	public TelevisionPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectPriceFilter() throws InterruptedException {
		Select sp = new Select(startPrice);
		sp.selectByValue("20000");
		Thread.sleep(2000); // This statement can't be avoided as explicit wait was unreliable here
		Assert.assertEquals("20000", sp.getFirstSelectedOption().getAttribute("value"));
		Select ep = new Select(endPrice);
		ep.selectByValue("60000");
		Thread.sleep(2000); // This statement can't be avoided as explicit wait was unreliable here
		Assert.assertEquals("60000", ep.getFirstSelectedOption().getAttribute("value"));
	}
	
	public void selectResolutionFilter() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", resolution);
		resolution.click();
		ultraHDchkbx.click();
		ReusableMethods.waitForElement(ultraHDchkbx);
		
	}
	
	public String getNoOfProducts() {
		return noOfProducts.getText();
	}
	
	public void addToCompare(int noOfProductsToCompare) {
		
		Iterator<WebElement> it = televisionList.iterator();
		for(int i = 0;i<noOfProductsToCompare;i++) {
			it.next().click();
		}
	}
	
	public ComparePage clickOnCompareBtn() {
		compareBtn.click();
		return new ComparePage();
	}

}
