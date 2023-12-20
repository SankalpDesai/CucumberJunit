package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;
	
	public WebDriver WebdriverManager() throws IOException {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String Url = prop.getProperty("QAUrl");
		String browser_properties=prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		
		//java ternery condition
		String browser= browser_maven!=null ? browser_maven : browser_properties;
		
		if(driver==null) {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("Webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(prop.getProperty("browser")=="edge") {
				//edge code
			}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(Url);
		}
		return driver;
	}
}
