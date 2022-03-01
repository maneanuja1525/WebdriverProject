package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		//Maximize Window
		driver.manage().window().maximize();
		//Wait for browser to load
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	
		WebElement element= driver.findElement(By.xpath("//button[@id='alertButton']"));
		element.click();
		//Accepting alert box
		Alert alert= driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		//Alert Cancel
		WebElement element1= driver.findElement(By.xpath("//button[@id='confirmButton']"));
		element1.click();
		Alert alert1= driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.dismiss();
		
		Thread.sleep(1000);//wait
		
		//Alert Message (Accepting input through alert)
		WebElement element2= driver.findElement(By.xpath("//button[@id='promtButton']"));
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("arguments[0].scrollIntoView();", element2);
		element2.click();
		Alert alert2= driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.sendKeys("Some Text");
		alert2.accept();
		
		
	}

}
