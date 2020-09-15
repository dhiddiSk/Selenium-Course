package locatorTechniquesLecturePractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdentifyLocators {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com");

		// driver.findElement(By.id("username")).sendKeys("dhiddi01"); // this line
		// enters the data at this "username" locator with key as "dhiddi01"

		// Locators using linktext
		driver.findElement(By.linkText("Forgot account?")).click();

		// driver.close();

		driver.get("https://www.linkedin.com/home");

		// Locators using name
		driver.findElement(By.name("keywords")).sendKeys("software testing");

		// What if the multiple inspected elements have the same ID. This results in the
		// considering the first object, even if we are intended to the second one's

		driver.get("https://www.facebook.com/");

		// driver.findElement(By.className("inputtext_55r1 _6luy")).sendKeys("pwd");
		// driver.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("");

		driver.get("https://login.salesforce.com/?locale=de");

		// Locators using cssSelector

		driver.findElement(By.cssSelector("#username")).sendKeys("sai");

		driver.findElement(By.cssSelector("#password")).sendKeys("123");

		// Locators using xpath
		driver.findElement(By.xpath("//*[@id=\'Login\']")).click();

		// Locatora using getText method.

		System.out.println(driver.findElement(By.cssSelector("#error.loginError")).getText());

		// driver.close();

		// ***************************************************************//
		// Generating the customized xpath from html attributes//

		// let me generate a customized xpath for twitter website.

		driver.get("https://www.facebook.com");

		// outer html copy is <input type="password" class="inputtext _55r1 _6luy"
		// name="pass" id="pass" data-testid="royal_pass" placeholder="Password"
		// aria-label="Password">

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");

	}

}
