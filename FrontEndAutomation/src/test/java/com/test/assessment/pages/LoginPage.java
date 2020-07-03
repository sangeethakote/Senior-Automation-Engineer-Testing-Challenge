package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    By SIGNIN_BUTTON = By.id("SignInLink");
    
    By USERNAME = By.id("WC_AccountDisplay_FormInput_logonId_In_Logon_1");
	
    By PASSWORD = By.id("WC_AccountDisplay_FormInput_logonPassword_In_Logon_1");
    
    By LOGIN_BUTTON = By.id("WC_AccountDisplay_links_2");
    
    WebDriver driver;

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

    public void login(String uname,String pass) {
    	driver.findElement(SIGNIN_BUTTON).click();
    	driver.findElement(By.xpath("/html/body/div[10]/div[2]/div/div/div[1]/a")).click();
    	driver.findElement(USERNAME).sendKeys(uname);
    	driver.findElement(PASSWORD).sendKeys(pass);
    	driver.findElement(LOGIN_BUTTON).click();
     
    }
}