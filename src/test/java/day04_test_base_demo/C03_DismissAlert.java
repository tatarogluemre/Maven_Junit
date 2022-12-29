package day04_test_base_demo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {

    @Test
    public void dismissAlertTest() throws InterruptedException {
   driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

//2. butona tıklayın,
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
// uyarıdaki Cancel(iptal) butonuna tıklayın
        Thread.sleep(4000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(4000);

// ve result mesajının "You clicked: Cancel" oldugunu test edin.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult="You clicked: Cancel";
        Assert.assertEquals(expectedResult,actualResult);

    }
}
