package com.gmail.perva4ina.tests;

import com.gmail.perva4ina.pages.LoginPage;
import com.gmail.perva4ina.pages.MailBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mailBoxPage = new MailBoxPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://mail.ukr.net/desktop/login?lang=ru");
    }

    @Test
    public void userLogin() {
        loginPage.setLogin("umachiha");
        loginPage.setPassword("idkfa666");
        loginPage.clickLogin();
        String mailUser = mailBoxPage.getUserMail();
        Assert.assertEquals(mailUser, "umachiha@ukr.net");
//
//        WebElement loginField = driver.findElement(By.id("login"));
//        WebElement passwordField = driver.findElement(By.id("password"));
//        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
//        loginField.sendKeys("umachiha");
//        passwordField.sendKeys("idkfa666");
//        loginButton.click();
//
//        WebElement buttonUser = driver.findElement(By.className("login-button__user"));
//        Assert.assertEquals("umachiha@ukr.net", buttonUser.getText());
    }

    @AfterClass
    public static void tearDown() {
        WebElement buttonUser = driver.findElement(By.className("login-button__user"));
        buttonUser.click();
        WebElement buttonLogout = driver.findElement(By.xpath("//a[@id='login__logout']/b"));
        buttonLogout.click();
//        driver.quit();
    }

}
