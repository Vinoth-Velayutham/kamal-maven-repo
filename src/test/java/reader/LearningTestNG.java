package reader;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LearningTestNG {
	@BeforeMethod
	public void iPrintDesign() {
		System.out.println("********************************");
	}

	@Test
	public void abc() {
		System.out.println("Hi kamal - 1");
	}

	@Test
	public void abcd() {
		System.out.println("Hi kamal - 2");
	}
	
	@AfterMethod
	public void iPrintDesigns() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}

	@BeforeSuite
	public void dataFromExcel() {
		System.out.println("Hi kamal - 3");
	}

}
