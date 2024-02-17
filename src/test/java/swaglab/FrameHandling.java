package swaglab;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FrameHandling {
	WebDriver driver;

	@Test
	public void letsHandleAFrame() throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://www.letskodeit.com/practice");

		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement iframeTitle = driver.findElement(By.xpath("//*[text()='iFrame Example']"));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView()", iframeTitle);
		
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='courses-iframe']"));
		
		driver.switchTo().frame(frameElement);
		Thread.sleep(2000);
		
		WebElement category = driver.findElement(By.xpath("//select[@name='categories']"));
		Thread.sleep(2000);
		Select langDropDown = new Select(category);
		Thread.sleep(2000);
		langDropDown.selectByVisibleText("Python");
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		driver.quit();

	}
}
