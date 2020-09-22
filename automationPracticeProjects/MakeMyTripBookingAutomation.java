import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Task Description: 1) Firstly enter in to homepage
 * 					 2) Choose the type of trip
 * 					 3) Enter  source and destination locations
 * 					 4) Enter departure and return date
 * 					 5) Choose the number of travellers, travellers class and then search
 */

public class MakeMyTripBookingAutomation {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver = new ChromeDriver();

		// Explicit wait has been choosen in order to make the webdriver only to pause at certain points

		WebDriverWait wait = new WebDriverWait(driver, 10);

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");

		driver.get("https://www.makemytrip.com/");

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		// Checking the presence of web-adds and closing it.
		
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("second-img")));
		
		
		boolean webAddPresent = driver.findElements(By.id("second-img")).size() > 0;

		if (webAddPresent) {

			driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
			
		  }
		}
		
		catch (Exception e) {
			System.out.println("No web adds are observed");
		}
		
		
		boolean loginelementPresentCopy = driver.findElements(By.xpath("//*[@id=\'SW\']/div[1]/div[1]/ul/li[6]/div[3]"))
				.size() > 0;

		if (loginelementPresentCopy) {

			driver.findElement(By.cssSelector("li[data-cy='account']")).click();

		}
		

		// Calling method to enter details of the journey

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

		origin = (String) js.executeScript("return arguments[0].value;", from);

		// System.out.println("The value of origin is "+origin);

		while (!origin.contains("Hyderabad")) {

			from.sendKeys(Keys.DOWN);

			origin = (String) js.executeScript("return arguments[0].value;", from);

		}
		
		from.sendKeys(Keys.ENTER);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-autowhatever-1")));

		WebElement tocity = driver.findElement(By.cssSelector("input[placeholder='To']"));

		tocity.sendKeys("Bom");

		String destination = null;

		destination = (String) js.executeScript("return arguments[0].value;", tocity);

		while (!destination.contains("Mumbai")) {

			tocity.sendKeys(Keys.DOWN);

			destination = (String) js.executeScript("return arguments[0].value;", tocity);
			
		}
		
		tocity.sendKeys(Keys.ENTER);

		schedule(driver, wait);

	}

	private static void schedule(WebDriver driver, WebDriverWait wait) {
		// TODO Auto-generated method stub

		// Entering departure and return date.

		List<WebElement> departureCalenderWeeks = new ArrayList<WebElement>();

		List<WebElement> departureDates = new ArrayList<WebElement>();

		String departureDateValue = null;
		
		WebElement departureMonthFrame = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[3]"));

		departureCalenderWeeks = departureMonthFrame.findElements(By.className("DayPicker-Week"));
		
		loop1:

		for (WebElement departureWeek : departureCalenderWeeks) {

			departureDates = departureWeek.findElements(By.cssSelector("div[role='gridcell']"));

			for (WebElement DepartureDate : departureDates) {

				departureDateValue = DepartureDate.getAttribute("aria-label");

				if (departureDateValue.contains("23")) {

					DepartureDate.click();
					break loop1;
				}

			}

		}
		
		
		List<WebElement> returnCalenderWeeks = new ArrayList<WebElement>();

		List<WebElement> returnDates = new ArrayList<WebElement>();
		
		String returnDateValue = null;
		
		WebElement returnMonthFrame = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[2]/div[3]"));

		returnCalenderWeeks = returnMonthFrame.findElements(By.className("DayPicker-Week"));
		
		loop2:

		for (WebElement returnWeek : returnCalenderWeeks) {

			returnDates = returnWeek.findElements(By.cssSelector("div[role='gridcell']"));

			for (WebElement returnDate : returnDates) {

				returnDateValue = returnDate.getAttribute("aria-label");

				if (returnDateValue.contains("23")) {

					returnDate.click();
					break loop2;
				}

			}

		}
		
		search(driver,wait);
	}
	
	
	private static void  search(WebDriver driver, WebDriverWait wait){
		//Number of travellers, memebers, class 
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='travellers']")));
		
		driver.findElement(By.cssSelector("label[for='travellers']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[data-cy='adultRange']")));
		
		driver.findElement(By.cssSelector("li[data-cy='adults-2']")).click();
		
		driver.findElement(By.cssSelector("li[data-cy='travellerApplyBtn']")).click();
		
		driver.findElement(By.className("primaryBtn.font24.latoBold.widgetSearchBtn.")).click();		
		
	}
	

}
