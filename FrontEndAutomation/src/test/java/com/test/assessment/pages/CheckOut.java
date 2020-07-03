package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOut {
	
	 By CART = By.id("widget_minishopcart");
	 By CHECKOUT_BUTTON = By.id("shopcartCheckout");
	 By PROCEED_TO_PAYMENT = By.id("WC_UnregisteredCheckout_links_4");
	    
	    WebDriver driver;

	    public CheckOut(WebDriver driver){

	        this.driver = driver;

	    }

	    public void checkout() {
    
	    	driver.findElement(CART).click();    	
	    	driver.findElement(CHECKOUT_BUTTON).click();
	    	
	    }
}
