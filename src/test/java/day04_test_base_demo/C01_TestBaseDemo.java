package day04_test_base_demo;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
//TestBase utilities classi abstract yapmamızın nedeni bu sınıfın objesini oluşturmak istemiyoruz
// TestBase testBase = new TestBase()-->abstracta yapılamaz  obje oluşturmadan method ları kullanmak utilities için abstract
// Amacımız bu sınıfı extend edip hazır methodları kullanmak.
    /*
    Utilities:
    Tekrar tekrar kullanacağamız method veya classları koyduğumuz paketin adıdır.
        -TestBase
        -Driver
        -ExelUtil
        -Configuration
     Utilities paketinde test case yazılmaz
     Sadece tekrar kullanılabilecek destek sınıfları(support class) oluşturulur.
     Bu support classlar test caselerin yazılmasını hızlandırır.
     */

    @Test
    public void test01() {
        //techproeducation ana sayfasına git ve titile in Bootcamps kelimesini içerdiğini test et

        driver.get("https://techproeducation.com");
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Bootcamp"));


    }
}
