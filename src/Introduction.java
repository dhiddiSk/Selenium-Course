import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Introduction {

	public static void main(String[] args) {

		System.getProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		// initialize the chrome driver.
		WebDriver driver = new ChromeDriver();

		driver.get("http://google.com");

		System.out.println(driver.getTitle());

		/*
		 * driver.getCurrentUrl() helps to validate if we are landed in correct url and
		 * prevents from being redirected to some other hacked website.
		 */

		System.out.println(driver.getCurrentUrl());

		/*
		 * For the concept frames in selenium, which deals with frames in the UI
		 * requires the page source of the website. To ge the page source use the below
		 * line of code. So one can get the page source directly by right clicking on
		 * the website, but some websites disable the option of right clicks.
		 */

		System.out.println(driver.getPageSource());

		driver.navigate().to("http://facebook.com");// this navigates to the given address
		driver.navigate().back();// this navigates back from current address
		driver.close();// this closes the current browser.
		driver.quit();// close all the browsers opened by the selenium

	}

}
