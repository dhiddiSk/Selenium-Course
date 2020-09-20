import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Task Description: 1) Firstly enter in to homepage
 * 					 2) Choose the type of trip
 * 					 3) Enter  source and destination locations
 * 					 4) Enter departure and return date
 * 					 5) Choose the number of travellers, travellers class and then search
 * 					 6) Now choose the latedepartures, non-stop options, then select the flight.
 * 					 7) Now select the flight and book it.
 */

public class MakeMyTripBookingAutomation {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		// Explicit wait has been choosen in order to make the webdriver only to wait at
		// certain points

		WebDriverWait wait = new WebDriverWait(driver, 5);

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		driver.get("https://www.makemytrip.com/");

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		Thread.sleep(3000);

		// check if the element is present. If there are no elements present then it
		// must return the empty list.

		boolean elementPresent = driver.findElements(By.xpath("//*[@id=\'SW\']/div[1]/div[1]/ul/li[6]/div[3]"))
				.size() > 0;

		if (elementPresent) {

			driver.findElement(By.cssSelector("li[data-cy='account']")).click();

		}

		Thread.sleep(5000);

		// Observed certain kind of web adds

		boolean webAddPresent = driver
				.findElements(By.id("webklipper-publisher-widget-container-notification-container")).size() > 0;

		if (webAddPresent) {

			driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();

		}

		// Calling to enter details of the passenger

		journeyPlace(driver, wait);

	}

	private static void journeyPlace(WebDriver driver, WebDriverWait wait) throws InterruptedException {

		// click on round trip radio button

		driver.findElement(By.cssSelector("li[data-cy='roundTrip']")).click();

		// Enter origin as Hyderabad and destination as Bombay

		driver.findElement(By.id("fromCity")).click();

		WebElement from = driver.findElement(By.cssSelector("input[placeholder='From']"));

		from.sendKeys("Hyd");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-autosuggest__section-title")));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String origin = null;
		String script = null;

		// script = "return arguments[0].value;\", inputTag";"

		origin = (String) js.executeScript("return arguments[0].value;", from);

		// System.out.println("The value of origin is "+origin);

		int stringPresent = 0;

		while (!origin.contains("Hyderabad")) {

			stringPresent++;

			from.sendKeys(Keys.DOWN);

			origin = (String) js.executeScript("return arguments[0].value;", from);

//		   if(stringPresent>10){
//			  break; 
//		   }

		}
		from.sendKeys(Keys.ENTER);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='To']")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-autowhatever-1")));

		WebElement tocity = driver.findElement(By.cssSelector("input[placeholder='To']"));

		tocity.sendKeys("Bom");

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-autowhatever-1")));

		String destination = null;
		// String script2 = null;

		destination = (String) js.executeScript("return arguments[0].value;", tocity);

		int stringPresent2 = 0;

		while (!destination.contains("Mumbai")) {

			stringPresent2++;

			tocity.sendKeys(Keys.DOWN);

			destination = (String) js.executeScript("return arguments[0].value;", tocity);

//		   if(stringPresent2>10){
//			  break; 
//		   }

		}
		tocity.sendKeys(Keys.ENTER);

		schedule(driver, wait);

	}

	private static void schedule(WebDriver driver, WebDriverWait wait) {
		// TODO Auto-generated method stub

		// Entering departure and return date.

		// driver.findElement(By.id("departure")).click();

		// get all the elements into a list and iterate through it to select for the
		// date.

		List<WebElement> calenderRows = new ArrayList<WebElement>();

		List<WebElement> dates = new ArrayList<WebElement>();

		String dateValue = null;

		calenderRows = driver.findElements(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[3]"));

		loop1:

		for (WebElement element : calenderRows) {

			dates = element.findElements(By.cssSelector("div[role='gridcell']"));

			for (WebElement date : dates) {

				dateValue = date.getAttribute("aria-label");

				if (dateValue.contains("sep 23")) {

					date.click();
					break loop1;
				}

			}

		}
		
		List<WebElement> calenderRows2 = new ArrayList<WebElement>();

		List<WebElement> dates2 = new ArrayList<WebElement>();

		String dateValue2 = null;

		calenderRows2 = driver.findElements(By.xpath("//div[@class='DayPicker-Months']/div[2]/div[3]"));
		
		
		
		
		loop2:

			for (WebElement element2 : calenderRows2) {

				dates2 = element2.findElements(By.cssSelector("div[role='gridcell']"));

				for (WebElement date2 : dates2) {

					dateValue2 = date2.getAttribute("aria-label");

					if (dateValue2.contains("oct 23")) {

						date2.click();
						break loop2;
					}

				}

			}	

	}

}
