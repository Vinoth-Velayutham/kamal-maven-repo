package swaglab;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindlowHandling {

	WebDriver driver;

	@Test
	public void handleAWindow() throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://www.letskodeit.com/practice");

		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement openWindow = driver.findElement(By.id("openwindow"));

		WebElement openTab = driver.findElement(By.id("opentab"));

		System.out.println("Title Before switch - " + driver.getTitle());

		openTab.click();
		
		iUseToSwitchWindowAndTab();

		System.out.println("Title After switch - " + driver.getTitle());

		WebElement homeButton = driver.findElement(By.xpath("//*[text()='HOME']"));
		homeButton.click();

		Thread.sleep(2000);
		driver.quit();

	}

	public void iUseToSwitchWindowAndTab() {
		String parentWindow = driver.getWindowHandle();

		Set<String> allWindow = driver.getWindowHandles();

		for (String childWindow : allWindow) {
			if (!(childWindow.equals(parentWindow))) {

				driver.switchTo().window(childWindow);

			}
		}
	}

}
