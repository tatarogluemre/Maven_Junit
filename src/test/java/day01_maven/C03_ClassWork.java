package day01_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class C03_ClassWork {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin
        //4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        boolean sayfabaslikTest = driver.findElement(By.xpath("//*[@alt='Google']")).isDisplayed();
        if(sayfabaslikTest){
            System.out.println("Google Başlık Test Passed");
        }else System.out.println("Google Başlık Test Failed");
        //5 Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);
        //6 Bulunan sonuc sayisini yazdirin
        List<WebElement> sonucSayisi = driver.findElements(By.xpath("//*[@id='result-stats']"));
        String[] arr = sonucSayisi.get(0).getText().split(" ");
        System.out.println("Nutella Arama Sonuc Sayısı = "+arr[1]);
        //7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        int sonuc = Integer.parseInt(arr[1].replace(".",""));
        System.out.println(sonuc);
        if(sonuc>100000000){
            System.out.println("Passed");
        }else System.out.println("Failed");
        //8 Sayfayi kapatin
        driver.close();
    }
}
