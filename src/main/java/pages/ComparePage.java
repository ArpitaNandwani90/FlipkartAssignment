package pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import util.ReusableMethods;

public class ComparePage extends TestBase{
	
	@FindBy(xpath = "//div[contains(@class,'1ouGhW')]//div[@class='_1vC4OE']")
	List<WebElement> productPrice;
	
	@FindBy(xpath = "//div[contains(@class,'1ouGhW')]//a[@class='_3YNWH1']")
	List<WebElement> productLink;
	
	
	public ComparePage() {
		PageFactory.initElements(driver, this);
	}
	
	public ProductPage getLowestPriceProduct() {
		Map<String, WebElement> product = new HashMap<String, WebElement>();
		List<String> price = new ArrayList<String>();
		String minprice = null;
		for(int i=0;i<productPrice.size();i++) {
			product.put(productPrice.get(i).getText(), productLink.get(i));
			price.add(productPrice.get(i).getText());
			Collections.sort(price);
			}
		ReusableMethods.takeScreenshot();
		minprice = price.get(0); //Lowest price of the product is fetched from the sorted list 'price'
		product.get(minprice).click();
		return new ProductPage();
		
	}

}
