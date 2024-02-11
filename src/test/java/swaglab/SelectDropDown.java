package swaglab;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectDropDown {

	@Test
	public void iSelectAValue() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.letskodeit.com/practice");

		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement selectDropDown = driver.findElement(By.id("carselect"));

		Select carDropDown = new Select(selectDropDown);

		carDropDown.selectByVisibleText("Honda");

		WebElement multiSelectDropDown = driver.findElement(By.id("multiple-select-example"));

		Select multiDropDown = new Select(multiSelectDropDown);

		multiDropDown.selectByIndex(0);
		Thread.sleep(2000);
		multiDropDown.selectByIndex(1);
		Thread.sleep(2000);
		multiDropDown.selectByIndex(2);
		Thread.sleep(2000);
		multiDropDown.deselectAll();
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
