package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();// used to maximize the screen
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);//used for wait
			
			WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
			WebElement password= driver.findElement(By.xpath("//input[@name='pass']"));
			WebElement btnLogin= driver.findElement(By.xpath("//button[@name='login']"));
			username.sendKeys("maneanuja921@gmail.com");
			password.sendKeys("anuja@15");
			btnLogin.click();
			
			WebElement errorMsg=driver.findElement(By.xpath("//*[text()= 'Find your account and log in.']"));
			String ActualMsg=errorMsg.getText();
			String ExpMsg="Find your account and log in.";
			if(ActualMsg.equals(ExpMsg))
			{
				System.out.println("Login Failed");
			}
			else {
				System.out.println("Logged in");
			}
			
			WebElement ForgotPass= driver.findElement(By.xpath("//div[@id='login_link']//a"));
			ForgotPass.click();
			
			driver.close();
			
	}

}
