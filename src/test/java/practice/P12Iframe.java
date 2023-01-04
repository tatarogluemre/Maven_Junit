package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P12Iframe extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //- https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        //    - youtube videosunu çalıştırınız
        WebElement frame = driver.findElement(By.xpath("//iframe[@frameborder='0']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();
        //    - yeni sekmede amazon adresine gidiniz
        String window1 = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https:amazon.com");
        //    - iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String result = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        String arr[]=result.split(" ");
        System.out.println("Iphone arama sonucu = "+ arr[2]);
        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(window1);
        System.out.println("Window1 url = "+driver.getCurrentUrl());
        Thread.sleep(3000);
        //    - ilk sekmeyi kapatalım
         driver.close();
        //    - Sonra diğer sekmeyide kapatalım
         //TestBase deki quit kapatacak


    }
}
