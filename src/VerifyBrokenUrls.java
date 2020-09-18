import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.UrlChecker;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class VerifyBrokenUrls {
	public static void main(String[] args) throws IOException, MalformedURLException {

		WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> urls = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		SoftAssert sa  = new SoftAssert();
		
		for (WebElement link : urls) {

			String url = link.getAttribute("href");

			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

			connection.setRequestMethod("HEAD");

			connection.connect();

			int reponseCode = connection.getResponseCode();

			
			
//			if (reponseCode > 400) {
//
//				System.out.println("This " + url + " is broken");
//				Assert.assertTrue(false);
//				
//			}
			
			sa.assertTrue(reponseCode > 400,"This " + url + " is broken");

		}
		
		sa.assertAll();
		
		

	}

}
