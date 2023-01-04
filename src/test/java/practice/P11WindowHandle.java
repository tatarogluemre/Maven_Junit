package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P11WindowHandle extends TestBase {
    @Test
    public void test01() throws InterruptedException {

//        Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");
//        Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindow = driver.getWindowHandle();
//        Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
//        Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
//        Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String actualTechproTitle = driver.getTitle();
        String expectedTechproTitle = "TECHPROEDUCATION";
        Assert.assertFalse(actualTechproTitle.contains(expectedTechproTitle));
//        Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://walmart.com");
//        Sayfa title’nin “Walmart” icerdigini test edin
        String actualWalmartTitle = driver.getTitle();
        String expectedWalmartTitle = "Walmart";
        Assert.assertTrue(actualWalmartTitle.contains(expectedWalmartTitle));
//        Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindow);
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        Thread.sleep(3000);
        switchToWindow("Walmart");
        Thread.sleep(3000);
    }
}
