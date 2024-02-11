package swaglab;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

		if (title.equals("Swag Labs")) {
			System.out.println("The validation passed title matches successfully");
		} else {
			System.out.println("The title doesn't matches");
		}

		WebElement usernameField = driver.findElement(By.id("user-name"));
		usernameField.sendKeys("standard_user");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauce");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		List<WebElement> prodTitle = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
		System.out.println("===================================================");
		System.out.println("The total number of products - " + prodTitle.size());
		System.out.println("===================================================");
		System.out.println("List of products --");

		for (WebElement produ : prodTitle) {
			System.out.println(produ.getText());
		}
		System.out.println("===================================================");
		List<WebElement> anchorTaglist = driver.findElements(By.xpath("//a"));

		for (WebElement tag : anchorTaglist) {
			System.out.println("The Hyper Links is - " + tag.getAttribute("href"));
		}
		System.out.println("===================================================");

		WebElement footerSection = driver.findElement(By.xpath("//div[@class='footer_copy']"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].scrollIntoView()", footerSection);
		Thread.sleep(3000);

		System.out.println("===================================================");
		WebElement backBag = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		backBag.click();

		Thread.sleep(5000);
		driver.quit();
		System.out.println("===================================================");
		// xpath Syntax - //tagname[@attribute='value']
		// text - //div[text()='Sauce Labs Backpack']

	}

}
