package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebTable {
    public static void main(String[] args) {


        String path ="C:\\mytools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
//        JavascriptExecutor js = (JavascriptExecutor) driver; //casting
//        driver.manage().window().maximize();
        System.out.println("open browser");
//        driver.get ("https://www.google.com/");
        driver.get ("https://demoqa.com/webtables");
        System.out.println("open url");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Scrolling
        String title = driver.getTitle();
        System.out.println(title);
        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);

        //add data
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("JuaraCoding");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("juara");
        driver.findElement(By.id("userEmail")).sendKeys("admin@juaracoding");
        driver.findElement(By.id("age")).sendKeys("20");
        driver.findElement(By.id("salary")).sendKeys("6000");
        driver.findElement(By.id("department")).sendKeys("QA Enginer");
        driver.findElement(By.id("submit"));

        //check box
        driver.get("https://demoqa.com/checkbox");
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[3]")).click();

        //Radio Button
        driver.get("https://demoqa.com/radio-button");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label")).click();
        String tampil = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span")).getText();
        System.out.println(tampil);
        //compare text = impresive, jika tidak maka failed
        if(tampil.equals("Impressive")){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }


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
