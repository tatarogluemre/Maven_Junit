package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P19AmazonArama extends TestBase {

    @Test
    public void test01() {

        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://amazon.com");
        // 2- nutella icin arama yapın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);
        // 3- yeni bir tab'da ilk urunun resmine tıklayınız

        //driver.switchTo().newWindow(WindowType.TAB).get("https://amazon.com");
        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);
        WebElement img = driver.findElement(By.xpath("//img[@data-image-index='1']"));
        actions.contextClick(img).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();

        // 4- yeni tab'da acilan urunun basligini yazdirin
        System.out.println(driver.findElement(By.id("productTitle")).getText());
        // 5- ilk sayfaya gecip url'i yazdırın
        List<String> handles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(0));
        //switchToWindow(1);
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    public void test02() {

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://amazon.com");
        // 2- url'in 'amazon' icerdigini test edelim
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("amazon"));
        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        // 4- title'in 'Best Buy' icerdigini test edelim
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Best Buy"));
        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        switchToWindow(1);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
        // 6- arama sonuclarının 'Java' icerdigini test edelim
        String actualText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(actualText.contains("java"));
        // 7- ikinci sayfaya(bestbuy) donelim
        switchToWindow(2);
        // 8- logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
