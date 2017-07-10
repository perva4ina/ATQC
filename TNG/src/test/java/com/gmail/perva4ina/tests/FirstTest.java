package com.gmail.perva4ina.tests;

import com.gmail.perva4ina.pages.iua_mail.LoginPage;
import com.gmail.perva4ina.pages.iua_mail.MailBoxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static MailBoxPage mailBoxPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/GIT/TNG/3rdParty/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mailBoxPage = new MailBoxPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://mail.ukr.net/desktop/login?lang=ru");
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
    public static void tearDown() {
        mailBoxPage.clickUser();
        mailBoxPage.clickLogout();
        driver.quit();
    }
}
