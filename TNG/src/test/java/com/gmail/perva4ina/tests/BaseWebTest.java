package com.gmail.perva4ina.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseWebTest {

    public static WebDriver driver;

    public static void initTest(String url) {
        System.setProperty("webdriver.chrome.driver", "C:/GIT/TNG/3rdParty/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get(url);
    }

    public static void finishTest() {
        driver.quit();
    }

}
