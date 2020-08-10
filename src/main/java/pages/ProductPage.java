package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ProductPage extends TestBase{
	
	@FindBy(xpath = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//span[text()='Cart']")
	WebElement cartBtn;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart() {
		addToCartBtn.click();
	}
	
	public CartPage openCart() {
		cartBtn.click();
		return new CartPage();
	}

}
