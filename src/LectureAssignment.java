import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Keyboard;

public class LectureAssignment {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// limiting the scope of the web driver to the footer elements

		WebElement footerLinksScope = driver.findElement(By.id("gf-BIG"));

		System.out.println(footerLinksScope.findElements(By.tagName("a")).size());

		// limiting the scope of web driver to particular column.

		WebElement footerCoulmnScope = footerLinksScope.findElement(By.xpath("//table/tbody/tr[1]/td/ul"));

		System.out.println(footerCoulmnScope.findElements(By.tagName("a")).size());

		// now click all the links and print the title from each web page

		for (int i = 1; i < footerCoulmnScope.findElements(By.tagName("a")).size(); i++) {

			String newtabString = Keys.chord(Keys.CONTROL, Keys.ENTER);

			footerCoulmnScope.findElements(By.tagName("a")).get(i).sendKeys(newtabString);
		}

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> its = windows.iterator();

		while (its.hasNext()) {

			String temp = its.next();

			driver.switchTo().window(temp);

			System.out.println(driver.getTitle());

		}

	}

}
