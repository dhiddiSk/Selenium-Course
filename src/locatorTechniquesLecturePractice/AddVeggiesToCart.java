package locatorTechniquesLecturePractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class AddVeggiesToCart {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		// asking selenium to wait for 5 seconds.

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// or one can use the explicit wait method as below

		WebDriverWait w = new WebDriverWait(driver, 5);

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		String[] vegetables = { "Brocolli", "Cauliflower", "Beans", "Onion", "Banana" };

		AddVeggiesToCart obj = new AddVeggiesToCart();

		obj.addingVeg(vegetables, w, driver);

	}

	public void addingVeg(String[] vegetables, WebDriverWait w, WebDriver driver) {

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.manage().window().maximize();

		List<String> vegetablesList = Arrays.asList(vegetables);

		List<WebElement> buttons = driver.findElements(By.cssSelector("div[class='product-action']"));

		List<WebElement> items = driver.findElements(By.cssSelector("h4[class='product-name']"));

		String[] vegetableNames;
		String name;

		for (int i = 0; i < items.size(); i++) {

			vegetableNames = items.get(i).getText().split("-");
			name = vegetableNames[0].trim();

			if (vegetablesList.contains(name)) {

				buttons.get(i).click();
			}
		}

		driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/a[4]/img")).click();

		driver.findElement(By.className("action-block")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promocode")));

		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("Promo");

		driver.findElement(By.xpath("//*[text()='Place Order']")).click();

	}

}
