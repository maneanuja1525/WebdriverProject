package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		//Maximize Window
		driver.manage().window().maximize();
		//Wait for browser to load
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	
		driver.switchTo().frame("frame1");
		WebElement sampleWindow=driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(sampleWindow.getText());
		
		driver.switchTo().defaultContent();// to switch to default frame
		
		System.out.println("after moving to default frame");
		driver.close();
		
	}

}
