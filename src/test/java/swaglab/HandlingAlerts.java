package swaglab;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingAlerts {
	
	@Test
	public void iHandleAlert() throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.letskodeit.com/practice");

		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement alertButton = driver.findElement(By.id("alertbtn"));
		
		WebElement confirmationAlertButton = driver.findElement(By.id("confirmbtn"));
		
		alertButton.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		confirmationAlertButton.click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
		
		
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
		
	}

}
