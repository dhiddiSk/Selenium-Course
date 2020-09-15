import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentFour {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		WebDriverWait w = new WebDriverWait(driver, 5);

		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Multiple Windows")).click();

		driver.findElement(By.linkText("Click Here")).click();

		Set<String> windowIds = driver.getWindowHandles();

		Iterator<String> its = windowIds.iterator();

		String parentId = its.next();

		String childId = its.next();

		driver.switchTo().window(childId);

		System.out.println(driver.getTitle());

		driver.switchTo().window(parentId);

		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));

		System.out.println(driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText());

	}

}
