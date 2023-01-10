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

        for(int i = 0 ; i<50 ; i++){

            actions.clickAndHold(cizimAlani);
                    actions.moveByOffset(i,i).perform();





        }

//          - Çizimden sonra clear butonuna basalım
//         - Son olarak sayfayı temizleyiniz


    }


    @Test
    public void test02() {

//        -https://jqueryui.com/slider/#colorpicker adrese gidiniz
//        -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız


    }
}
