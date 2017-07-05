package com.gmail.perva4ina.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://goo.gl/wh2MP8");
    }

    public Select getSelect(WebElement element) {
        return new Select(element);
    }

    @Test
    public void selectText() {

        WebElement listText = driver.findElement(By.xpath("//p[contains(.,\"Тег select предназначен для создания выпадающего списка.\")]/following-sibling::table[1]//select"));
        Select select = getSelect(listText);
        select.selectByVisibleText("Textarea");

        WebElement listValue = driver.findElement(By.xpath("//p[contains(.,\"Тег select предназначен для создания выпадающего списка.\")]/following-sibling::table[3]//select"));
        select = getSelect(listValue);
        select.selectByValue("2");

        WebElement listIndex = driver.findElement(By.xpath("//p[contains(.,\"Тег select предназначен для создания выпадающего списка.\")]/following-sibling::table[6]//select"));
        select = getSelect(listIndex);
        select.selectByIndex(2);


//        loginPage.setLogin("umachiha");
//        loginPage.setPassword("idkfa666");
//        loginPage.clickLogin();
//        String mailUser = mailBoxPage.getUserMail();
//        Assert.assertEquals(mailUser, "umachiha@ukr.net");
    }

//    @AfterClass
//    public static void tearDown() {
//        mailBoxPage.clickUser();
//        mailBoxPage.clickLogout();
//        driver.quit();
//    }

}
