package com.gmail.perva4ina.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseWebTest {

    public WebDriver driver;

    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/GIT/TNG/3rdParty/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    public void setupDriver(String url) {
        setupDriver();
        driver.get(url);
    }

    public void finishTest() {
        driver.quit();
    }

}
