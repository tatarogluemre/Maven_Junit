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
        actions.clickAndHold(cizimAlani);

        for(int i = 0 ; i<10 ; i++){

                    actions.moveByOffset(i*i,i).perform();


        }

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
        WebElement green = driver.findElement(By.xpath("(//span[@tabindex='0'])[2]"));
        actions.moveToElement(green);
        for(int i = 100 ; i>=0 ; i--){
            actions.dragAndDropBy(green,i,0).build().perform();
        }

        WebElement blue = driver.findElement(By.id("blue"));
        actions.dragAndDropBy(blue,0,0).build().perform();

    }
}
