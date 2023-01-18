package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class P24_FileUpload extends TestBase {
    @Test
    public void test01() {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");
        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        String path = System.getProperty("user.home")+"/Desktop/logo.jpeg";
        driver.findElement(By.id("uploadfile_0")).sendKeys(path);
        // I accept terms of service bölümünü tikleyin
        driver.findElement(By.id("terms")).click();
        // Submit File buttonuna basınız
        driver.findElement(By.id("submitbutton")).click();
        // "1 file has been successfully uploaded" görünür olduğunu test edin
        WebElement upload = driver.findElement(By.id("res"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("res")));
        Assert.assertTrue(upload.isDisplayed());
    }
}
