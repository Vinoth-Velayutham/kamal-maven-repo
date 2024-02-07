package swaglab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginSwagLab {

	@Test
	public void verifySwagLab() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");

		driver.manage().window().maximize();

		String title = driver.getTitle();

		System.out.println("The title of the webpage is " + title);

		if (title.equals("SwagLabs")) {
			System.out.println("The validation passed title matches successfully");
		} else {
			System.out.println("The title doesn't matches");
		}

		Thread.sleep(5000);
		driver.quit();
	}

}
