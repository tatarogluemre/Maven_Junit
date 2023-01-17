package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P18ActionsCizim extends TestBase {
    @Test
    public void test01() {

        // - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
//         - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement cizimAlani = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));
        actions.moveToElement(cizimAlani).clickAndHold();

        for(int i = 0 ; i<10 ; i++){

            actions.moveByOffset(5,5);
        }
        for(int i = 0 ; i<10 ; i++){

            actions.moveByOffset(-5,0);
        }
        for(int i = 0 ; i<10 ; i++){

            actions.moveByOffset(0,-5);
        }
        actions.release().build().perform();

//          - Çizimden sonra clear butonuna basalım
        driver.findElement(By.xpath("//button[@data-action='clear']")).click();
//         - Son olarak sayfayı temizleyiniz
              driver.navigate().refresh();

    }


    @Test
    public void test02() {

//        -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
//        -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
          //i frame var
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame);
        WebElement green = driver.findElement(By.xpath("(//span[@tabindex='0'])[2]"));
        actions.dragAndDropBy(green,-170,0);
        WebElement blue = driver.findElement(By.id("blue"));
        actions.dragAndDropBy(blue,-170,0);
        actions.dragAndDropBy(green,301,0).release().build().perform();
        WebElement sari = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        assert sari.isDisplayed();

    }
}
