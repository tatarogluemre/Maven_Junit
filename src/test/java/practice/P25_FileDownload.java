package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class P25_FileDownload extends TestBase {
    @Test
    public void test01() {

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browser = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'][1]"));
        actions.moveToElement(browser).click().perform();
        waitFor(2);
        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("(//a[text()='documentation'])[5]")).click();
        waitFor(2);
        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//a[@class='XqQF9c'])[1]")).click();
        //Açılan pencerede chromedriver'i indirelim
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        driver.findElement(By.xpath("//table//tbody//tr[7]//td[2]")).click();
        //Driver'in indiğini doğrulayalım
         waitFor(10);
        String path = System.getProperty("user.home")+"/Downloads/chromedriver_win32.zip";
        boolean filedownload = Files.exists(Paths.get(path));
        Assert.assertTrue(filedownload);
    }
}
