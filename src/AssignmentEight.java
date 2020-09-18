import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentEight {

	static String origin = null;
	static String script = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();

		WebElement suggession = driver.findElement(By.id("autocomplete"));

		suggession.sendKeys("Ind");

		Thread.sleep(2000);

		suggession.sendKeys(Keys.DOWN);
		suggession.sendKeys(Keys.DOWN);
		suggession.sendKeys(Keys.ENTER);

	}

}