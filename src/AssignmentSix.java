import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentSix {

	/*
	 * Task:
	 * 
	 * 1) select the check box and grab the label of it.
	 * 
	 * 2) Next select the dropdown example option matching the checkbox label
	 * 
	 * 3) Enter the grabbed label text in edit box
	 * 
	 * 4) Click alert and then verify if text grabbed from step1 is present in the
	 * popup message.
	 * 
	 * 
	 * 
	 * Do not hardcode the label part.
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// 1) selecting the check box and grab the label of it.

		driver.manage().window().maximize();

		driver.findElement(By.id("checkBoxOption1")).click();

		String grabbedValue = driver.findElement(By.cssSelector("label[for='bmw']")).getText();

		// System.out.println(grabbedValue);

		Select select = new Select(driver.findElement(By.id("dropdown-class-example")));

		select.selectByVisibleText(grabbedValue);

		driver.findElement(By.cssSelector("input[placeholder='Enter Your Name']")).sendKeys(grabbedValue);

		driver.findElement(By.id("alertbtn")).click();

		String alertText = driver.switchTo().alert().getText();

		if (alertText.contains(grabbedValue)) {
			driver.switchTo().alert().accept();
		} else {

			driver.switchTo().alert().dismiss();
		}

	}

}
