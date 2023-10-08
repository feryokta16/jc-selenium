package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\mytools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("open browser");
        driver.get ("https://demoqa.com/alerts");
        System.out.println("open url");
        driver.manage().window().maximize();

        //Alert
        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.id("alertButton")).click();
        delay(5);// 5detik


        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("juaracoding");
        driver.switchTo().alert().accept();





        //Delay
        delay(3);//3 detik
        driver.quit();
        System.out.println("close browser");
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
