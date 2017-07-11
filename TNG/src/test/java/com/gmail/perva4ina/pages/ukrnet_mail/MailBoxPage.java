package com.gmail.perva4ina.pages.ukrnet_mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by perva on 02.07.2017.
 */
public class MailBoxPage {

    WebDriver driver;

    public MailBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login-button__user")
    private WebElement buttonUser;

    @FindBy(className = "login-button__user")
    private WebElement buttonLogout;

    public void openUserMenu() {
        buttonUser.click();
    }

    public void clickLogout() {
        buttonLogout.click();
    }

    public String getUserMail() {
        return buttonUser.getText();
    }

}
