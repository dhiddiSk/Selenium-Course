import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Introduction {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*
	 *  In this machine it was required with installation of the chrome driver. After installation it works even
	    with out the below code line.
	 */
	
	//System.getProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		
		System.out.println(driver.getTitle());
		
		/*
		 *  helps to validate if we are landed in correct url, because sometimes some times we may be redirected to
		 *  some other website which is hacked.
		
		 */
		
		System.out.println(driver.getCurrentUrl());
		
		/*
		 * For the concept frames in selenium, which deals with frames in the UI requires the page source of the website.
		 * To ge the page source use the below line of code.
		 * So one can get the pagesource directly by right clicking on the website.
		 * But some websites disable that option of rightclicks.
		 */
		
		System.out.println(driver.getPageSource());
		
		
		driver.navigate().to("http://facebook.com");// this navigates to the given address
		driver.navigate().back();// this navigates back from current address
		driver.close();// this closes the current browser.
		driver.quit();// close all the browsers opened by the selenium
		
		
		
	}


}
