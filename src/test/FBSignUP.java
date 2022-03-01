package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUP {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement createAccount=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		createAccount.click();
		WebElement firstname=driver.findElement(By.xpath("//input[@aria-label='First name']"));
		WebElement lastname=driver.findElement(By.xpath("//input[@aria-label='Surname']"));
		WebElement email=driver.findElement(By.cssSelector("input[aria-label='Mobile number or email address']"));
		WebElement reEnterEmail=driver.findElement(By.xpath("//input[@aria-label='Re-enter email address']"));
		WebElement password=driver.findElement(By.cssSelector("input[aria-label='New password']"));
		firstname.sendKeys("Anuja");
		lastname.sendKeys("Patil");
		email.sendKeys("maneanuja2515@gmail.com");
		reEnterEmail.sendKeys("maneanuja2515@gmail.com");
		//String email1=email.getText();
		//reEnterEmail.sendKeys(email1);
		password.sendKeys("anuja@1525");
		
		//Shows the list of all months 
		List<WebElement> Months=driver.findElements(By.xpath("//select[@aria-label='Month']/option"));
		for(WebElement element:Months) {
			System.out.println(element.getText());
		}
		//Prints current month
		WebElement currentMonth= driver.findElement(By.xpath("//select[@aria-label='Month']/option[@selected='1']"));
		System.out.println("Current Month: "+currentMonth.getText());
		
		WebElement Day=driver.findElement(By.xpath("//select[@id='day']"));
		Select ddDay=new Select(Day);		//select class is used for dropdown. its provided by selenium
		ddDay.selectByVisibleText("15");
		
		WebElement month=driver.findElement(By.xpath("//select[@id='month']"));
		Select ddMonth=new Select(month);
		ddMonth.selectByVisibleText("May");
		
		WebElement Year=driver.findElement(By.xpath("//select[@id='year']"));
		Select ddYear=new Select(Year);
		ddYear.selectByVisibleText("1996");
		
		String strGender="Female";
		////label[text()='Female']/following-sibling::input
		String genXpath="//label[text()='"+strGender+"']/following-sibling::input";
		WebElement gender=driver.findElement(By.xpath(genXpath));
		gender.click();
	
		WebElement signUP=driver.findElement(By.xpath("//button[@name='websubmit']"));
		signUP.click();
		Thread.sleep(2000);
		
		WebElement ErrorMsg=driver.findElement(By.xpath("//div[@id='reg_error']/div"));
		String ActualMsg=ErrorMsg.getText();
		String ExpMsg="There was an error with your registration. Please try registering again.";
		if(ActualMsg.equals(ExpMsg))
		{
			System.out.println("Plase Try again with Signup");
			
		}	
		else 
		{
			System.out.println("Account created successfully");
		}
		
		
	}

}
