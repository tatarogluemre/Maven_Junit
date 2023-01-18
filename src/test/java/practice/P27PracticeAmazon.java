package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P27PracticeAmazon extends TestBase {
    @Test
    public void test01() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //Sonuçlarda Sadece Apple Iphone yazılanlara tıklayalım
        List<WebElement> list = driver.findElements(By.partialLinkText("Apple iPhone"));

        for(int i =0 ; i<list.size();i++){
             list = driver.findElements(By.partialLinkText("Apple iPhone"));
             list.get(i).click();
             driver.navigate().back();

        }


    }
}
