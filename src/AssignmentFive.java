import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentFive {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		driver.get("https://the-internet.herokuapp.com/nested_frames");

		driver.switchTo().frame(driver.findElement(By.name("frame-top")));

		// driver.switchTo().frame(driver.findElement(By.name("frameset-middle")));

		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));

		System.out.println(driver.findElement(By.id("content")).getText());

	}

}
