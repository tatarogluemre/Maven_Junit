package day10_exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

/*

Explicit wait kullanıldığında ve element bulunamadığında,
Explicit wait & yanlış locater da,
Explicit wait & doğru locater & süre yeterlidağilse
Explicit wait & doğru locater &süre yeterli & iframe var ise timeout exception alınır

Çözüm:
-Süreyi artırabiliriz.
-Farklı explicit wait  visibility OElementLocated yerine PresenceOfElementLocater kullanılabilir.
-Yada javascriptexecutor kullanarak çözümlenebilir.
-Locaterı tekrar kontrol etmek
-Frameworkümde hazır reusable methodlar var Bu durumda timeout exception handle edebiliriz

 */

    @Test
    public void name() {

        driver.get("https://techproeducation.com");
        //Explicit wait için oluşturduğumuz methodlardan birini kullanalım
        //Parametre 1: beklemek istediğim element .Pametre 2: max sure
        //waitForVisibility(  driver.findElement(By.xpath("//input[@type='searchhh']")),15).sendKeys("qa", Keys.ENTER);
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("driver.findElement(By.xpath(\"//input[@type='searchhh']")));

    }
}
