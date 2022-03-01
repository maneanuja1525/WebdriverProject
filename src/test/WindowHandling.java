package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		//Maximize Window
		driver.manage().window().maximize();
		//Wait for browser to load
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	
		String ParentWin=driver.getWindowHandle();
		System.out.println("\n Before clicking new window:  "+ParentWin);
		
		//WebElement new_Window=driver.findElement(By.xpath("//button[@id='windowButton']"));
		//new_Window.click();
		WebElement newTab=driver.findElement(By.xpath("//button[@id='tabButton']"));
		newTab.click();
		System.out.println("\n After clicking new window button");
		Thread.sleep(1000);
		Set<String> windowHandles=driver.getWindowHandles();
		Iterator<String>itr=windowHandles.iterator();
		while(itr.hasNext()) 
		{
			String currentWin=itr.next();
			System.out.println(currentWin);
			if(!currentWin.equals(ParentWin))
			{
				driver.switchTo().window(currentWin);
			}
		}
		
		WebElement sampleWindow=driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(sampleWindow.getText());
		driver.close();
		driver.switchTo().window(ParentWin);
		System.out.println("Back to pratent Window");
		driver.close();
		
		
		
		
	}

}
