package LocatorTechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;


public class AddVeggiesToCart {
	
	public static void main(String[] args) throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.manage().window().maximize();
		
		String[] vegetables = {"Brocolli", "Cauliflower", "Beans", "Onion", "Banana"};
		
		List<String> vegetablesList = Arrays.asList(vegetables);
		
		List<WebElement> buttons = driver.findElements(By.cssSelector("div[class='product-action']"));
		
		List<WebElement> items = driver.findElements(By.cssSelector("h4[class='product-name']"));
		
		String[] vegetableNames;
		String name;
		
		for(int i=0; i<items.size(); i++) {
			
			vegetableNames = items.get(i).getText().split("-");
			name = vegetableNames[0].trim();
			
			if(vegetablesList.contains(name)) {
				
				buttons.get(i).click();
				
			}
			
			
		}
		
		
		driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/a[4]/img")).click();
		
		driver.findElement(By.className("action-block")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[text()='Place Order']")).click();

		
		
	}
}
