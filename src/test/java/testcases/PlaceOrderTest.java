package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.ComparePage;
import pages.HomePage;
import pages.ProductPage;
import pages.TelevisionPage;
import util.Constants;

public class PlaceOrderTest extends TestBase{
	
	public PlaceOrderTest() {
		super();
	}
	
	HomePage homepage;
	TelevisionPage televisionpage;
	ComparePage comparepage;
	ProductPage productpage;
	CartPage cartpage;
	
	@Test
	public void placeOrderTest() throws InterruptedException {
		homepage = new HomePage();
		televisionpage = homepage.selectTelevision();
		televisionpage.selectPriceFilter();
		televisionpage.selectResolutionFilter();
		String msg = televisionpage.getNoOfProducts();
		System.out.println(msg);
		televisionpage.addToCompare(3); //Here we can specify the number of products to compare by passing desired value as argument
		comparepage = televisionpage.clickOnCompareBtn();
		productpage = comparepage.getLowestPriceProduct();
		productpage.addToCart();
		cartpage = productpage.openCart();
		String currentwindowtitle = cartpage.clickHelpCenter();
		Assert.assertEquals(Constants.expectedtitle, currentwindowtitle,"Could not Switch to HelpCenter Window");
		String currenturl=cartpage.placeOrder();
		Assert.assertEquals(Constants.expectedurl, currenturl,"Could not place order");
	}

}
