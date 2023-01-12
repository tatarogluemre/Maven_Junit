package day10_exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

    /*
    StateElementReferenceException
StateElementReferenceException = eski kullanılamaz durumda olan, kullanıma artık elverişli olmayan durumlarda alınan hatadır.
Sayfayı yenilediğimizde,
sayfada ileri geri gittiğimizde meydana gelen exception'dır.

    Çözüm
Elemanı tekrar bulmak.

 */

    @Test
    public void test01() {

        driver.get("https://techproeducation.com");
        waitFor(3);
        //Lms login butonuna tıkla o sayfanın urlsinin lms içerdiğini test et
        WebElement lmsButton= driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        lmsButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));
        waitFor(5);
         //Tekrar ana sayfaya gel ve lms login butonuna tıkla
        driver.navigate().back();
        waitFor(5);
        lmsButton.click();
        //Tekrar ana sayfaya gel ve lms login butonuna tıkla
        driver.navigate().back();
        waitFor(5);
        lmsButton.click();
    }

    @Test
    public void test02() {
        driver.get("https://www.techproeducation.com");
        waitFor(5);
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
//        SAYFA YENILENMEDEN ONCE BULDUGUM ELEMENTI, SAYFA YENILENDIKDEN SONRA KULLANMAK ISTEDIM
        lmsLoginLink.click();// org.openqa.selenium.StaleElementReferenceException
//        COZUM ESKI(SLATE ELEMENT) ELEMENTI TEKRAR LOCATE ET
//        driver.findElement(By.linkText("LMS LOGIN")).click();

    }
}
