package day01_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_Maven {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        https://www.amazon.com/ sayfasina gidelim
          driver.get("https://www.amazon.com/");
          driver.navigate().refresh();
//        2 arama kutusunu locate edelim
        WebElement aramakutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
//        3 “Samsung headphones” ile arama yapalim
        aramakutusu.sendKeys("samsung headphones", Keys.ENTER);
//        4 Bulunan sonuc sayisini yazdiralim
       List<WebElement> sonucSayisi = driver.findElements(By.xpath("(//*[@class='sg-col-inner'])[1]"));
       String[] arr = sonucSayisi.get(0).getText().split(" ");
        System.out.println("Samsung Headphones Arama Sonuc Sayısı = "+ arr[2]);
//        5 Ilk urunu tiklayalim
        List<WebElement> ilk = driver.findElements(By.xpath("(//*[@class='s-image'])[1]"));
        ilk.get(0).click();
//        6 Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//h1"));
        for (WebElement w : sayfaBasliklari){
            System.out.println(w.getText());
        }
//Lambda ile yazdırma
        sayfaBasliklari.stream().forEach(t-> System.out.println(t.getText()));
        driver.close();

    }
}
