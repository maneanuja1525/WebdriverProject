package test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.simplilearn.com");
		driver.manage().window().maximize();//To maximize the window size
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);//
		
		WebElement LoginText= driver.findElement(By.linkText("Log in"));
		LoginText.click();
		//WebElement Simage=driver.findElement(By.xpath("//div[@class='col-centered content-wrapper']/div[1]/img"));
		
		WebElement Username=driver.findElement(By.xpath("//input[@class='email']"));
		WebElement Password=driver.findElement(By.xpath("//input[@id='password']"));
		WebElement RememberMe= driver.findElement(By.className("rememberMe"));
		WebElement Submit=driver.findElement(By.xpath("//input[@type='submit']"));
		Username.sendKeys("maneanuja2515@gmail.com");
		Password.sendKeys("Anuja@15");
		RememberMe.click();
		Submit.click();
		//for validating login msg
		WebElement ErrorMsg= driver.findElement(By.id("msg_box"));
		String ActualMsg=ErrorMsg.getText();
		String ExpMsg="The email or password you have entered is invalid.";
		 if(ActualMsg.equals(ExpMsg)) {
			 System.out.println("TS Passed");
		 }
		 else
		 {
			 System.out.println("TC Failed");
		 }
		
		 //to get all links present on web page
		 List<WebElement> links=driver.findElements(By.tagName("a"));
		 System.out.println("Total no.of links: "+links.size());
		 
		 for(WebElement element:links)
		 {
			 System.out.println(element.getAttribute("href"));
		 }
		driver.close();
		
		
	}

}
