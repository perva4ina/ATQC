package com.gmail.perva4ina;

import com.gmail.perva4ina.BE.OnlineShop.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class mainclass {
    public static void main(String [] args){
//        System.out.println("Hello, world!");
        Product product = new Product();
        product.setNaming("Tesoro Gram Spectrum");
        product.setProductDescription("Mechanical keyboard");
        product.setPrice(new BigDecimal("179.00"));
        product.setAvailable(3);
        product.addEntity();
    }
}
