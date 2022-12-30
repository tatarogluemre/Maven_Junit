package day04_test_base_demo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_Iframe extends TestBase {

//    Iframe nedir?


    @Test
    public void test01() {
    //
    driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
  //    Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
     String actualText = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']")).getText();
     String expectedText = "black border";
     Assert.assertTrue(actualText.contains(expectedText));
  // Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //Applications lists yazısı iframe içinde onun için iframe içine bu şekilde geçiş yapmalıyız.
        driver.switchTo().frame(0);//iframe index 0 dan başlar
        String actualTextAp=driver.findElement(By.xpath("//h1[text()='Applications lists']")).getText();
        String expectedTextAp="Applications lists";
        Assert.assertEquals(expectedTextAp,actualTextAp);
 //    Son olarak footer daki ‘Powered By’ yazisini varligini test edilip sayfayı kapatın
        //driver.switchTo().defaultContent();//iframe içinden çıkmak için kullanıyoruz.
        driver.switchTo().parentFrame(); //de kullanılabilir.

        String actualTextPwr = driver.findElement(By.xpath("(//p[text()='Povered By'])[1]")).getText();
        System.out.println("actualTextPwr = " + actualTextPwr);
        String expectedTextPwr = "Povered By";
        Assert.assertTrue(actualTextPwr.contains(expectedTextPwr));

    }


}
