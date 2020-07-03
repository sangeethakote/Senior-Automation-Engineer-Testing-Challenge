package com.test.assessment.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	By SEARCH_BOX = By.id("SimpleSearchForm_SearchTerm");
	By SEARCH_SUBMITT = By.id("search_submit");
	By ITEM = By.xpath("//fieldset/div/div/div[2]");
	By ADD_TO_BAG = By.xpath("//a[@class='add-to-bag-btn']");
	By POST_CODE = By.id("WC__AddressEntryForm_FormInput_zipCode_0");
    
    WebDriver driver;

    public SearchPage(WebDriver driver){

        this.driver = driver;

    }
    
    public void searchProduct(String product) throws InterruptedException {
    	
    	WebDriverWait wait=new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_BOX));
    	driver.findElement(SEARCH_BOX).sendKeys(product);
    	driver.findElement(SEARCH_SUBMITT).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"resultcontent\"]")));
    	driver.findElement(ITEM).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_BAG));
    	driver.findElement(ADD_TO_BAG).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(POST_CODE));
    	driver.findElement(POST_CODE).sendKeys("3150");
    	//driver.findElement(POST_CODE).sendKeys(Keys.ENTER);
    	Thread.sleep(3000);
    	driver.findElement(POST_CODE).sendKeys(Keys.ENTER);
    	
  }

}
