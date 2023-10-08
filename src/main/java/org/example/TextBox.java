package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox {
    public static void main(String[] args) {
        String path ="C:\\mytools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver; //casting
        driver.manage().window().maximize();
        System.out.println("open browser");
        driver.get ("https://www.google.com/");
        driver.get ("https://demoqa.com/text-box");
        System.out.println("open url");

        //Locator Search
        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("admin@juaracoding.com");
        driver.findElement(By.id("currentAddress")).sendKeys("bandung");

        //scroll
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("submit")).click();


        //Delay
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("close browser");
    }
}

//cari keyword google mencari scroll = scroll selenium java
