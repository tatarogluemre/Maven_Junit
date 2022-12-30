package day05handlewindow;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01WindowHandle extends TestBase {
    /*
    Bazen bir butona tıkladığımızda, başkabir sekmede(tab) yeni bir pencereaçılır.
●Birden fazla pencereyle calişirken driver’a pencereler arasında gecis yaptirmamizgerekir.
●Pencereler arasında gecis yapmak icin windowhandle degerini kullaniriz.
●window handle : Selenium WebDriver’in, WebDriver objesi başlatıldığında her pencereye verdigi
                  unique alfanumerik kimlikdegeridir.

1) Icinde oldugumuz sayfanin window handle degerinialma
driver.getWindowHandle();
2) Pencereler arasında geçişyapma(switch)
driver.switchTo().window(sayfa1HandleDegeri);

3) Yeni tab olusturup geçişyapma(switch)
driver.switchTo().newWindow(WindowType.TAB);
4) Yeni window olusturup geçişyapma(switch)
driver.switchTo().newWindow(WindowType.WINDOW);
     */


    @Test
    public void test01() throws InterruptedException {
//
//        Tests package’inda yeni bir class olusturun: WindowHandle
//        https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
//        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

//        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

//        Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Thread.sleep(3000);

//        Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        //Bu noktada 2 pencere açık ve ikincisine geçiş yapmak istiyoruz
        //Bunun için tüm pencerelerin id lerini  driver.getWindowHandles() kullanarak alacağız.

           Set<String> handles = driver.getWindowHandles();
           handles.stream().forEach(t-> System.out.println(t)); //sadece id leri yazırmak için lamda

        String window1 = driver.getWindowHandle();


        for(String w : handles){

            if(!w.equals(window1)){

                driver.switchTo().window(w);
                break;
            }
        }
        String window2 = driver.getWindowHandle();
        String window2Title = driver.getTitle();
        Assert.assertEquals("New Window",window2Title);
//        Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualText1 = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        Assert.assertEquals("New Window",actualText1);
//        Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        Thread.sleep(3000);
        driver.switchTo().window(window1);
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);
        Thread.sleep(2000);
 //    Tekrar 2.window'a geçelim
        driver.switchTo().window(window2);
        Thread.sleep(2000);
  //    Tekrar 1. Window a geçelim
        driver.switchTo().window(window1);

    }

}
