package com.gmail.perva4ina.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SelectTest extends BaseWebTest{
//    private static WebDriver driver;
    private Select select;
    private String selectText = "Textarea";

    @BeforeClass
    public void setup() {
        setupDriver("https://goo.gl/wh2MP8");
    }

    public Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }

    @Test
    public void selectText() {
        WebElement listText = driver.findElement(By.xpath("//p[contains(.,\"Тег select предназначен для создания выпадающего списка.\")]/following-sibling::table[1]//select"));
        getSelect(listText);
        select.selectByVisibleText(selectText);
        WebElement selectedOption = select.getFirstSelectedOption();
        Assert.assertEquals(selectText, selectedOption.getText());
    }
    
    @Test
    public void  selectValue() {
        WebElement listValue = driver.findElement(By.xpath("//p[contains(.,\"Тег select предназначен для создания выпадающего списка.\")]/following-sibling::table[3]//select"));
        getSelect(listValue);
        select.selectByValue("2");
        WebElement selectedOption = select.getFirstSelectedOption();
        Assert.assertEquals(selectText, selectedOption.getText());
    }
    
    @Test
    public void selectIndex() {
        WebElement listIndex = driver.findElement(By.xpath("//p[contains(.,\"Тег select предназначен для создания выпадающего списка.\")]/following-sibling::table[6]//select"));
        getSelect(listIndex);
        select.selectByIndex(2);
        List<WebElement> selectedOption = select.getAllSelectedOptions();
        Assert.assertEquals(selectText, selectedOption.get(0).getText());
    }
    
    @Test
    public void isMultipleTest() {
        WebElement listIndex = driver.findElement(By.xpath("//p[contains(.,\"Тег select предназначен для создания выпадающего списка.\")]/following-sibling::table[6]//select"));
        getSelect(listIndex);
        boolean multiple = select.isMultiple();
        Assert.assertFalse(multiple);
    }

    @Test
    public void optionsTest() {
        WebElement listText = driver.findElement(By.xpath("//p[contains(.,\"Тег select предназначен для создания выпадающего списка.\")]/following-sibling::table[1]//select"));
        getSelect(listText);
        List<WebElement> options = select.getOptions();
        int i = 1;
        for(WebElement option : options){
            System.out.println(i + " oпция списка: " + option.getText());
            i++;
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
