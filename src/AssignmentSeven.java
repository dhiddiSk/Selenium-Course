import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentSeven {

	/*
	 * Task is to print the number of rows, columns, secondRowdata
	 */

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement table = driver.findElement(By.id("product"));

		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

		// xpath("//table[@class='table-display']/tbody/tr[1]/th")).size());

		for (int i = 0; i < table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")).size(); i++) {

			System.out.println(
					table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")).get(i).getText());

		}

	}
}
