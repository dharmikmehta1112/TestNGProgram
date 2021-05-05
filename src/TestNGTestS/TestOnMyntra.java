package TestNGTestS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * package: org.openqa.selenium.interactions
 * public class Actions in Selenium is use for complex user gestures (actions of Keyboard/Mouse e.g. hover).
 * 
 * package: org.testng
 * public class Assert in TestNG is used to asserting/comparing/checking/verifying 2 parameters.
 * All methods of assert class are static e.g. assertEquals(), assetTrue(), assertFalse() etc.
 * public static void assertEquals(String actual, String expected): Asserts that two Strings are equal.
 *                                                                  If they are not, an AssertionError is thrown.
 * @author Dharmik Mehta
 */
public class TestOnMyntra {
	@Test
	public void TC_01() {
		String menexpectedUrl = "https://www.myntra.com/men-tshirts";
		String womenexpectedUrl = "https://www.myntra.com/women-trousers";
		System.setProperty("webdriver.chrome.driver", "D:\\Jars\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.myntra.com");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement men = driver.findElement(By.xpath("//a[@data-group = 'men']"));
		Actions action = new Actions(driver);
		action.moveToElement(men).perform();
		driver.findElement(By.xpath("//a[@href = '/men-tshirts']")).click();
		String menactualUrl = driver.getCurrentUrl();
		Assert.assertEquals(menactualUrl, menexpectedUrl);
		driver.navigate().back();
		WebElement women = driver.findElement(By.xpath("//a[@data-group = 'women']"));
		action.moveToElement(women).perform();
		driver.findElement(By.xpath("//a[@href = '/women-trousers']")).click();
		String womenactualUrl = driver.getCurrentUrl();
		Assert.assertEquals(womenactualUrl, womenexpectedUrl);
	}
}