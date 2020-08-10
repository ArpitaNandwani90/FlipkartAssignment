package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class ReusableMethods extends TestBase{
	
	
	public static void waitForElement(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void failed() {
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File("C:\\Users\\Arpita\\eclipse-workspace\\FlipkartAssignment\\Screenshot\\testfailed.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void takeScreenshot() {
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile,new File("C:\\Users\\Arpita\\eclipse-workspace\\FlipkartAssignment\\Screenshot\\compareProducts.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
}

}
