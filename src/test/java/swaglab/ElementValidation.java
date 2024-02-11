package swaglab;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ElementValidation {
	@Test
	public void letsDoIt() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.letskodeit.com/practice");

		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		System.out.println("===================================================");

		WebElement displayMessage = driver.findElement(By.xpath("//legend[text()='Element Displayed Example']"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].scrollIntoView()", displayMessage);

		System.out.println("===================================================");

		WebElement hideButton = driver.findElement(By.id("hide-textbox"));

		WebElement showButton = driver.findElement(By.id("show-textbox"));

		WebElement displayContent = driver.findElement(By.id("displayed-text"));

		iValidateAnElement(displayContent);
		System.out.println("===================================================");
		hideButton.click();

		iValidateAnElement(displayContent);
		System.out.println("===================================================");
		showButton.click();

		iValidateAnElement(displayContent);
		System.out.println("===================================================");
		Thread.sleep(5000);
		driver.quit();
		System.out.println("===================================================");
		
		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(displayContent));

	}

	public void iValidateAnElement(WebElement ele) {

		boolean isElementDisplayed = ele.isDisplayed();

		if (isElementDisplayed) {
			System.out.println("Yes! The Element is displayed.");
		} else {
			System.err.println("No! The Element is not displayed.");
		}

	}
	
	public void iValidateEnable(WebElement ele) {

		boolean isElementDisplayed = ele.isEnabled();

		if (isElementDisplayed) {
			System.out.println("Yes! The Element is Enable.");
		} else {
			System.err.println("No! The Element is not Enabled.");
		}

	}

}
