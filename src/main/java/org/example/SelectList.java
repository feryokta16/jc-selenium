package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SelectList {
    public static void main(String[] args) {
        String LinkDemoga = "https://demoqa.com/select-menu";
        System.setProperty("webdriver.chrome.driver","C:\\mytools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("open browser");
        driver.get (LinkDemoga);
        System.out.println("open url");
        driver.manage().window().maximize();

        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);
        Select pilihwarna = new Select (driver.findElement(By.id("oldSelectMenu")));
        pilihwarna.selectByValue("4");
        pilihwarna.selectByVisibleText("Blue");
        pilihwarna.selectByIndex(8);
        System.out.println("pilih indigo");
    }
}
