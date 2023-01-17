package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class HesapMakina extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        int sayi1 = randomNumber();
        System.out.println("sayi1 = " + sayi1);
        islemler();
        int sayi2 = randomNumber();
        System.out.println("sayi2 = " + sayi2);
        String[]arr=driver.findElement(By.xpath("//div[@class='screen']")).getText().split("");
        String islem = arr[2];
        System.out.println("islem = " + islem);
        double toplam = 0.0;
        switch (islem) {

            case "+":
                toplam += sayi1 + sayi2;
                break;
            case "-":
                toplam += sayi1 - sayi2;
                break;
            case "x":
                toplam += sayi1 * sayi2;
                break;
            default:
                toplam +=sayi1/sayi2;

        }
        System.out.println("toplam = " + toplam);


        driver.findElement(By.xpath("//span[@class='btn btn-outline-warning']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("spinner")));
        String son = driver.findElement((By.xpath("//div[@class='screen']"))).getText();
        System.out.println("son = " + son);
        double sonuc = Double.valueOf(son);
        System.out.println("sonuc = " + sonuc);
        Assert.assertTrue(toplam==sonuc);


    }

    public int randomNumber() {
        String sayilar = "";

        int sayi = (int) (Math.random() * 10);
        if (sayi > 0 && sayi < 11) {
            for (int i = 0; i < 2; i++) {
                WebElement sayii = driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[" + sayi + "]"));
                sayii.click();
                waitFor(1);
                sayilar += sayii.getText();
            }
        } else {
            randomNumber();
        }

        int say = Integer.valueOf(sayilar);
        return say;

    }

    public void islemler() throws InterruptedException {

        int sayi = (int) (Math.random() * 10);
        if (sayi > 0 && sayi < 5) {
            WebElement islem = driver.findElement(By.xpath("(//span[@class='operator btn btn-outline-success'])[" + sayi + "]"));
            islem.click();
            waitFor(1);

        } else {
            islemler();

        }

    }
}
