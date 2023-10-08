package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\mytools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("open browser");
        driver.get ("https://www.google.com/");
        System.out.println("open url");

        //Locator Search
        driver.findElement(By.name("q")).sendKeys("Wikipedia");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

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