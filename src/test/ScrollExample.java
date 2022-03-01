package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		//Maximize Window
		driver.manage().window().maximize();
		//Wait for browser to load
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement element = driver.findElement(By.xpath("//h2[text()='Table Rows']"));
		
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("arguments[0].scrollIntoView();", element); //To scroll to particular element
		Thread.sleep(3000);
		//Scroll down
		obj.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(3000);
		//Scroll UP
		obj.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		
	}

}
