package day07_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01Actions extends TestBase {
    @Test
    public void testActions01() {
//        https://the-internet.herokuapp.com/context_menu  sitesine gidin
          driver.get("https://the-internet.herokuapp.com/context_menu ");
//        Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(kutu).perform();//Tüm actionslar actions ile başlar perform() ile biter.
        wait(2);
//        Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        String actualText= driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Assert.assertEquals(expectedText,actualText);
////        Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();




    }
}
