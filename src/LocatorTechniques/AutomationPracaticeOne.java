package LocatorTechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPracaticeOne {
	
	
	public static void main(String[] args){
		
		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.chrome.driver", "/home/saikrishna/Downloads/chromedriver_linux64/chromedriver");
			
		// practice web page from rahulshettu academy
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//Now search products from the search-keyword entry bar, its name starting with br.
		
		driver.findElement(By.className("search-keyword")).sendKeys("Brocolli");
		
		//add 3kgs of Brocolli
		
		int i=0;
		int BrocolliCost = 0;
		while(i<3) {
			
			driver.findElement(By.xpath("//div[@id='root']/div/div[1]/div/div[1]/div[3]/button")).click();
			i++;
			BrocolliCost += 120;
			
			
		}
		
		// Now check the cart to verify the number of items were collected and total price calculated for those items.
		
		driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/a[4]/img")).click();
		
		if(Integer.parseInt(driver.findElement(By.className("amount")).getText()) == 360){
			
			driver.findElement(By.className("action-block")).click();
		}
		else {
		    System.out.println("The computed amount for brocolli is wrong");
		    //driver.close();
		}
		

		//Now generate a customized xpath using text locators and click on place order.
	
		driver.findElement(By.cssSelector("#root > div > div > div > div:nth-child(4) > button")).click();
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//driver.findElement(By.xpath("//*[@id=\'root\']/div/footer/p")).getText();
		
	
	}

}
