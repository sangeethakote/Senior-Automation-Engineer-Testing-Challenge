package com.test.assessment.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.assessment.pages.CheckOut;
import com.test.assessment.pages.LoginPage;
import com.test.assessment.pages.SearchPage;

public class TestRunner {
	private WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.kmart.com.au/");
	}
	
	@Test(priority = 0)
	public void login() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		Thread.sleep(3000);
		loginpage.login("sangeetha.shreyas@gmail.com","Test@@123");
	}
	
	@Test(priority = 1)
	public void searchproduct() throws InterruptedException {
		SearchPage sp = new SearchPage(driver);
		sp.searchProduct("toys");
	}
	
	@Test(priority = 2)
	public void checkout() {
		CheckOut co = new CheckOut(driver);
	    co.checkout();
	    
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
