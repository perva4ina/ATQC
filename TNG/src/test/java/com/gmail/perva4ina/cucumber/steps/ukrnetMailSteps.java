package com.gmail.perva4ina.cucumber.steps;

import com.gmail.perva4ina.pages.ukrnet_mail.LoginPage;
import com.gmail.perva4ina.pages.ukrnet_mail.MailBoxPage;
import com.gmail.perva4ina.tests.BaseWebTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class ukrnetMailSteps extends BaseWebTest{

    private LoginPage loginPage;
    private MailBoxPage mailBoxPage;

//    {
//        loginPage = new LoginPage(driver);
//        mailBoxPage = new MailBoxPage(driver);
//    }

    @Before
    public void setup() {
        setupDriver();
        loginPage = new LoginPage(driver);
        mailBoxPage = new MailBoxPage(driver);
    }

    @After
    public void tearDown() {
        finishTest();
    }

    @Given("user is on ukr.net Mail Login Page")
    public void openLoginPage() {
        driver.get("https://mail.ukr.net");
    }

    @When("he enter username \"([^\"]*)\"")
    public void enterUserName(String userName) {
        loginPage.setLogin(userName);
    }

    @When("he enter password \"([^\"]*)\"")
    public void enterPassword(String password) {
        loginPage.setPassword(password);
    }

    @When("click Login button")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @When("user open User Menu")
    public void openUserMenu() {
        mailBoxPage.openUserMenu();
    }

    @When("click Logout button")
    public void clickButtonLogout() {
        mailBoxPage.clickLogout();
    }

    @Then("MailBoxPage displayed with \"([^\"]*)\" user")
    public void verifyMailBoxPageDisplayed(String expected) {
        String actual = mailBoxPage.getUserMail();
        Assert.assertEquals(actual, expected);
    }

    @Then("LoginPage displayed")
    public void verifyMailBoxPageDisplayed() {
        Assert.assertTrue(loginPage.getButtonLogin().isDisplayed());
    }
}
