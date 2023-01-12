package day10_exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01NoSuchElementException extends TestBase {

    /*
    //NoSuchElementException:

 Yanlis locator
Popup, yeni pencere, iframe,…
Sayfa dolmada problemler ve yavaslamalar
Sakli olan elementler

Solution:
Locatorin dogrulugunu tekrar kontrol et
Manual test ile iframe, yeni pencere, alert,… gibi elementlerin varligini kontrol et.
Bekleme problemi olabilir. Implicit wait bekleme suresini cozmuyor. Bu durumda explicit wait yada fluent wait kullaniriz
     */



    @Test
    public void test01() {
//NoSuchElementException implicity wait kullanıp web element bulunamadığında alınır.
        //techproeducation.com sayfasına git
        driver.get("https://techproeducation.com");
        //yanlış locate ile NosuchElementException al
        driver.findElement(By.xpath("//input[@type='searchhh']")).
                sendKeys("qa", Keys.ENTER);

    }
}
