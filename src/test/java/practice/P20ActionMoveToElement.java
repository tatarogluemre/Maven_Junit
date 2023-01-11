package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P20ActionMoveToElement extends TestBase {
    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dil = driver.findElement(By.id("icp-nav-flyout"));
        actions.moveToElement(dil).perform();
        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();
        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
          WebElement country = driver.findElement(By.id("icp-dropdown"));
         Select select = new Select(country);
         select.selectByVisibleText("Turkey (Türkiye)");
         driver.findElement(By.xpath("//span[@class='a-text-bold']")).click();
          //selectDropdown(country,"Turkey(Türkiye)");
        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//span[@id='icp-save-button']")).click();
        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        List<String> handles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Elektronik"));

    }
}
