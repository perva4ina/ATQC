package com.gmail.perva4ina.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login")
    private WebElement fieldLogin;

    @FindBy(id = "password")
    private WebElement fieldPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonLogin;

    public void setLogin(String login) {
        fieldLogin.sendKeys(login);
    }

    public void setPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    public void clickLogin() {
        buttonLogin.click();
    }


//    WebElement loginField = driver.findElement(By.id("login"));
//    WebElement passwordField = driver.findElement(By.id("password"));
//    WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
//        loginField.sendKeys("umachiha");
//        passwordField.sendKeys("idkfa666");
//        loginButton.click();

}
