package swaglab;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class StoreScreenshot {

	WebDriver driver;

	@Test
	public void iTakeAScreenShot() throws IOException, InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://www.letskodeit.com/practice");

		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		String screenShotPath = System.getProperty("user.dir") + "\\src\\test\\resources\\screenshot\\code.png";

		File destpath = new File(screenShotPath);

		TakesScreenshot scrshot = (TakesScreenshot) driver;
		File scrSht = scrshot.getScreenshotAs(OutputType.FILE);

		FileHandler.copy(scrSht, destpath);
		
		Thread.sleep(2000);
		driver.quit();

	}

}
