import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AssignmentTwo {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("profile.default_content_setting_values.notifications", 1);

		// 1-Allow, 2-Block, 0-default

		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.cleartrip.com/");

		driver.manage().window().maximize();

		Select adultPeople = new Select(driver.findElement(By.id("Adults")));

		adultPeople.selectByIndex(2);

		Select children = new Select(driver.findElement(By.id("Childrens")));

		children.selectByIndex(2);

		driver.findElement(By.id("DepartDate")).click();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();

		driver.findElement(By.id("MoreOptionsLink")).click();

		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo");

		driver.findElement(By.id("SearchBtn")).click();

		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

	}
}
