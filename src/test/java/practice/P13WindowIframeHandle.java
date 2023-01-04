package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P13WindowIframeHandle extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//p")).clear();
        driver.findElement(By.xpath("//p")).sendKeys("Techproeducation");
        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumLink = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumLink.isDisplayed());
        // Elemental Selenium linkine tıklayın
        elementalSeleniumLink.click();
        // Açılan sayfada sayfa başlığını yazdırınız
        switchToWindow("Elemental Selenium");
        System.out.println(driver.getTitle());
        //2.Yol
        List<String> handles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement sourceLabsLink = driver.findElement(By.xpath("//a[@class='link']"));
        Assert.assertTrue(sourceLabsLink.isDisplayed());
        // Source labs linkine tıklayın
        sourceLabsLink.click();
        // Açılan sayfada sayfa başlığını yazdırınız
       switchWindowListMethod(3);
        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        switchWindowListMethod(1);
        // ilk sekmeyi kapatalım
        driver.close();
        //ikinci pencereye geçiş yapalım
        switchWindowListMethod(2);
        Thread.sleep(3000);
    }
}
