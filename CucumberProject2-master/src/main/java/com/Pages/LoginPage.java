package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;
    //1.By Locators
    private By uname=By.xpath("//*[@placeholder='Username']");
    private By password=By.xpath("//*[@placeholder='Password']");
    private By signInButton=By.xpath("//*[@type='submit']");
    private By forgotpwdLink=By.xpath("//*[text()='Forgot your password???']");
    //2.Constructor of page class

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public String getLoginPageTitle(){
        return driver.getTitle();
    }
    public boolean isForgotpwdLinkExist(){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        return driver.findElement(forgotpwdLink).isDisplayed();
    }

    public void enterUserName(String username){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(uname).sendKeys(username);
    }
    public void enterpassword(String psword){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(password).sendKeys(psword);
    }
    public void clickOnLogin(){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(signInButton).click();
    }

    public DashboardPage doLogin(String un,String pwd){
        System.out.println("login with"+un+"and "+pwd);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(uname).sendKeys(un);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(password).sendKeys(pwd);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(signInButton).click();
        return new DashboardPage(driver);

    }
}
