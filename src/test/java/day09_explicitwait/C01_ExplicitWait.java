package day09_explicitwait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {
    @Test
    public void test01() {

//        https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        Start buttonuna tıkla
        driver.findElement(By.xpath("//button[text()='Start']")).click();
//        Hello World! Yazının sitede oldugunu test et

       //String actualText = driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText();
       // Assert.assertEquals("Hello World!",actualText);
        //ımplicitwait bu testin geçmesini sağlamadı explicit wait kullanmak gerekir.
        //explicitwait spesifik olarak istenilen web elemntin yüklenmesini bekler ve aynı zamanda o elemnti locate edebilir.
//   1.Adım WebdriverWait objesini oluştur.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//     2.Adım wait objesini kullanarak bekleme problemini çözmeye çalış
       WebElement helloworld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
       String actualText = helloworld.getText();
       Assert.assertEquals("Hello World!",actualText);


    }
}
