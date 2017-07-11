package com.gmail.perva4ina.tests;

import com.gmail.perva4ina.pages.ukrnet_mail.LoginPage;
import com.gmail.perva4ina.pages.ukrnet_mail.MailBoxPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest extends BaseWebTest {
    private static LoginPage loginPage;
    private static MailBoxPage mailBoxPage;

    @BeforeClass
    public void setup() {
        setupDriver("https://mail.ukr.net/desktop/login?lang=ru");
        loginPage = new LoginPage(driver);
        mailBoxPage = new MailBoxPage(driver);
    }

    @Test
    public void userLogin() {
        loginPage.setLogin("umachiha1");
        loginPage.setPassword("test1234!");
        loginPage.clickLogin();
        String mailUser = mailBoxPage.getUserMail();
        Assert.assertEquals(mailUser, "umachiha1@ukr.net");
    }

    @AfterClass
    public void tearDown() {
        mailBoxPage.openUserMenu();
        mailBoxPage.clickLogout();
        finishTest();
    }
}
