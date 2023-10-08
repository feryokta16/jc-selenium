import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TugasMingguTigaTest {
    public static void main(String[] args) {
        String path ="C:\\mytools\\chromedriver-win64\\chromedriver.exe";//penyimpanan dari laptop
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://juice-shop.herokuapp.com/#/login");
        System.out.println("Open URL");

        //TUTUP IKLAN
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]/span[1]/span")).click();
        //Masukan Username dan Password
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("feryokta1603@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("#Amala1908");
        delay(3);
        //Button Login
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-login[1]/div[1]/mat-card[1]/div[1]/button[1]/span[1]")).click();
        delay(20);

        //Add to Basket
        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button/span[1]/span")).click();
        delay(10);
        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]/span[1]/span[1]")).click();
        delay(2);

        //IF ELSE ASSERT LOGIN JIKA SESUAI MAKA AKAN MENAMPILKAN BERHASIL LOGIN DAN OWASP JICE SHOP
        String tampil = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[2]/span[1]/span")).getText();
        if(tampil.equals("OWASP Juice Shop")){
            Assert.assertEquals(tampil,"OWASP Juice Shop");
            System.out.println("Berhasiil Login");
        }else{
            System.out.println("failed");
        }
        System.out.println(tampil);

        //IF ELSE ASSERT ADD TO BASKET APABILA SESUAI MAKA AKAN BERHASIL DITAMBAHKAN DAN PRODUCT YANG DI TAMBAHKAN YAITU APPLE JICE SHOP
        String add = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-basket/mat-card/app-purchase-basket/mat-table/mat-row/mat-cell[2]")).getText();
        if(add.equals("Apple Juice (1000ml)")){
            Assert.assertEquals(add,"Apple Juice (1000ml)");
            System.out.println("berhasil menambahkan");
        }else{
            System.out.println("failed");
        }
        System.out.println(add);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
