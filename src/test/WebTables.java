package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		//Maximize Window
		driver.manage().window().maximize();
		//Wait for browser to load
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		List<WebElement> tbRows=driver.findElements(By.xpath("//table[@id='customers']//tr"));
		List<WebElement> tbColumn=driver.findElements(By.xpath("//table[@id='customers']//tr[1]/th"));
		System.out.println("Total no.of Rows: "+tbRows.size());
		System.out.println("Total no.of Columns: "+tbColumn.size());
		
		List<WebElement> tbData=driver.findElements(By.xpath("//table[@id='customers']//tr[4]/td"));
		for(WebElement element:tbData) {
			
			System.out.println(element.getText());
		}
		
		List<WebElement> tbCoulmnData=driver.findElements(By.xpath("//table[@id=\"customers\"]//tr/td[3]"));
		System.out.println("\n Data Present in first column");
		for(WebElement elm:tbCoulmnData) {
			System.out.println(elm.getText());
		}
		
		
		driver.close();
	}

}
