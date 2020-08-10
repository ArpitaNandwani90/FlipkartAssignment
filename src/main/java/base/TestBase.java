package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Arpita\\eclipse-workspace\\FlipkartAssignment\\src\\main\\java\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@BeforeMethod
	public void setUp() {
		String browserName = prop.getProperty("browser");
		if(browserName.contentEquals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Arpita\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arpita\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("base_url"));
		driver.findElement(By.xpath("//button[@class = '_2AkmmA _29YdH8']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
