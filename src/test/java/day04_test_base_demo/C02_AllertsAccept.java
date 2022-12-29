package day04_test_base_demo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AllertsAccept extends TestBase {

    @Test
    public void acceptAllertTest() {
     //https://testcenter.techproeducation.com/index.php?page=javascript-alerts sayfasına gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
     //1. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
    //uyarıdaki OK butonuna tıklayın
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.
                switchTo().//değiştir
                alert().//allerte değiştir
                accept();//ok tıkla
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //ve result mesajının “You successfully clicked an alert” oldugunu test edin.

        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult="You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);


/*
Allertler nasıl automate edilir?
Allertler i incele(inspect) yapamayız WebElemnt değildirler JavaScript ile oluşurlar.
Bunun için switch() metodu kullanarak handle edilir.
 */

    }
}
