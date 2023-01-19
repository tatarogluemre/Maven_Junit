package day14_javascriptexecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C01JsExecuter_Scroll extends TestBase {
    @Test
    public void test01() throws IOException {

//        Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
//        scrollIntoViewTest metotu olustur
        JavascriptExecutor js = (JavascriptExecutor)driver;
//        We Offer elementi gorunur olacak sekilde uzerine scroll et
        WebElement weoffer = driver.findElement(By.xpath("//span[.='we offer']"));
        //scrollIntoView(true); metodu belirlenen elemente scroll yapmak için kullanılır.
        //arguments[0] ilk parametrededki elementtir.
        js.executeScript("arguments[0].scrollIntoView(true);",weoffer);
        //ve sayfanın ekran goruntusunu al
        takeScreenShotOfPage();
        waitFor(3);
//        Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement enroll = driver.findElement(By.xpath("//span[text()='Enroll Free Course']"));
        scrollIntoViewJs(enroll);
        takeScreenShotOfPage();
        waitFor(3);
//        Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement whyus= driver.findElement(By.xpath("//h3[.='WHY US?']"));
        scrollIntoViewJs(whyus);
        takeScreenShotOfPage();
        waitFor(3);
//        Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement enrollfree = driver.findElement(By.xpath("//span[.='Enroll Free Course']"));
        scrollIntoViewJs(enrollfree);
        takeScreenShotOfPage();
        waitFor(3);

        //sayfanın en üstüne git
        scrollTopOfPageJs();
        waitFor(2);
        //sayfanın en altına git
        scrollEndOfPageJs();
    }
}
