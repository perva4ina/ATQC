package com.gmail.perva4ina.pages.ukrnet_mail;

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

    public WebElement getButtonLogin() {
        return this.buttonLogin;
    }

    public void setLogin(String login) {
        fieldLogin.sendKeys(login);
    }

    public void setPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    public void clickLogin() {
        buttonLogin.click();
    }

}
