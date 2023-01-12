package day09_explicitwait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class C02_FluentWait extends TestBase {

    @Test
    public void test01() {

//        https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        Start buttonuna tıkla
        driver.findElement(By.xpath("//button[text()='Start']")).click();
//        Hello World! Yazının sitede oldugunu test et
        // 1. Adım Fluent Wait için obje oluştur
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))//Max bekleme suresi
                .pollingEvery(Duration.ofSeconds(3))//Fluent waiti farklı yapan method deneme aralıkları
                .withMessage("IGNORE EXCEPTION")//opsiyonel olarak mesaj yazdırabiliriz mecburi değil
                .ignoring(NoSuchMethodException.class);//Exception handle et opsiyonel zorunlu değil

    WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
    String actualText = helloWorld.getText();
        Assert.assertEquals("Hello World!",actualText);





    }
}
