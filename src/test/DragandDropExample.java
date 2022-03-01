package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class DragandDropExample {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");   
		//Maximize Window
		driver.manage().window().maximize();
		//Wait for browser to load
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement From= driver.findElement(By.xpath("//li[@id='credit2']/a"));
		WebElement To=driver.findElement(By.xpath("//ol[@id='bank']/li"));
		
		WebElement From1=driver.findElement(By.xpath("//li[@id='fourth']/a"));
		WebElement To1=driver.findElement(By.xpath("//ol[@id='amt7']/li"));
		
		Actions act=new Actions(driver); //using action class we can do interactive operations
		act.dragAndDrop(From, To).build().perform();
		act.contextClick();
		
		act.dragAndDrop(From1, To1).build().perform();
		
		
		
	}

}
