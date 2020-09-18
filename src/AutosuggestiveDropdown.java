import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutosuggestiveDropdown {

	/*
	 * Enter the keyword ben of banglore in the from city box.
	 * 
	 * Check for the airport place and select it.
	 * 
	 * goto the destination place and enter keyword chi for chitoor.
	 */
	static String origin = null;
	static String script = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		driver.get("https://ksrtc.in/oprs-web/");

		driver.manage().window().maximize();

		WebElement fromcity = driver.findElement(By.id("fromPlaceName"));

		fromcity.click();

		fromcity.sendKeys("ben");

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		script = "return document.getElementById(\"fromPlaceName\").value;";

		origin = (String) js.executeScript(script);

		int k = 0;

		while (!origin.contains("AIRPORT")) {
			k++;

			fromcity.sendKeys(Keys.DOWN);

			origin = (String) js.executeScript(script);

			// System.out.println(origin);
			if (k > 10)
				break;

		}
		fromcity.sendKeys(Keys.ENTER);

	}
}
