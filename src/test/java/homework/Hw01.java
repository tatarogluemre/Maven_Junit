package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Hw01 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
 //    Bir class olusturun: IframeOdev
//    https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get(" https://the-internet.herokuapp.com/iframe ");
//    sayfadaki toplam iframe sayısını bulunuz.
        int iframeSayisi = driver.findElements(By.tagName("iframe")).size();
        System.out.println("iframeSayisi = " + iframeSayisi);
//    Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText ="Editor";
        Assert.assertTrue(actualText.contains(expectedText));
//    Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//p")).clear();
        Thread.sleep(3000);
//    Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        driver.findElement(By.xpath("//p")).sendKeys("iframe içindeyim");
        Thread.sleep(3000);
//    Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().parentFrame();
        String actualTextfooter = driver.findElement(By.linkText("Elemental Selenium")).getText();
        String expectedTextFooter = "Elemental Selenium";
        Assert.assertTrue(actualTextfooter.contains(expectedTextFooter));

    }

}
