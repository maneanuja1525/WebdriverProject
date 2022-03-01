package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");
		//Maximize Window
		driver.manage().window().maximize();
		//Wait for browser to load
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	
		WebElement fileUpload=driver.findElement(By.xpath("//input[@name='uploadfile_0']"));
		fileUpload.sendKeys("C:\\epfo.pdf");
		WebElement Tcheck=driver.findElement(By.xpath("//input[@name='terms']"));
		Tcheck.click();
		WebElement submit=driver.findElement(By.xpath("//button[@id='submitbutton']"));
		submit.click();
		
		
	}

}
