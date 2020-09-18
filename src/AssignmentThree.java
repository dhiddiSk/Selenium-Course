import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentThree {
	
	
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		WebDriverWait w = new WebDriverWait(driver, 5);

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

		driver.findElement(By.linkText("Click to load get data via Ajax!")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));

		System.out.println(driver.findElement(By.id("results")).getText());
	}

}
