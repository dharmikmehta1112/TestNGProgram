package TestNGTestS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * A Property files (.properties) are mainly used in java programs to maintain
 * project configuration data, database configuration or project setting.
 * 
 * A Property file / config.properties file (contains data in form of pair of string: key-value.
 * 
 * Our config.properties file is present in Folder: Configuration.
 * 
 * In selenium, a property file is used to store GUI Locators/Elements and also global fields.
 * 
 * @author Dharmik Mehta
 */
public class ReadConfigFile {

	WebDriver driver;
	Properties prop;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Jars\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();			
		} else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Jars\\FirefoxDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")){
			System.setProperty("webdriver.edge.driver", "D:\\Jars\\EdgeDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Ivalid Browser");
		}
	}

	@Test
	public void testLogin() {
		readconfigurationfile();		// concrete method
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("user-name")).sendKeys(prop.getProperty("uname"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("pass"));
		driver.findElement(By.id("login-button")).click();
		System.out.println("Passed Successfully");
//		Assert.assertTrue(false, "Invalid Login!!");
	}
	
	public void readconfigurationfile() {
		
		prop = new Properties();		// Object created to read a property file

// In path always use single forward slash or double backward slash		
		try {
//			FileInputStream fis = new FileInputStream("../Configuration/config.properties");
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/Configuration/config.properties");
//			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
//			FileInputStream fis = new FileInputStream("D:/Java Program/Eclipse/TestNGPractice/Configuration/config.properties");
//			FileInputStream fis = new FileInputStream("D:\\Java Program\\Eclipse\\TestNGPractice\\Configuration\\config.properties");

			prop.load(fis);		// a method of properties class - to load the configuration
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}

	@AfterMethod
	public void setDown() {
		driver.quit();
	}
}