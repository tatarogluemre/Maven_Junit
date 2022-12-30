package day04_test_base_demo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {
    @Test
    public void promptAlertTest() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
 //      3. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
//    uyarıdaki metin kutusuna isminizi yazin,
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Emre");
        Thread.sleep(4000);
//    OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(4000);
//    ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult="Emre";
        Assert.assertTrue(actualResult.contains(expectedResult));
Thread.sleep(3000);
    }
}
