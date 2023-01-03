package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P10Iframe extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ ");
        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> emojis = driver.findElements(By.xpath("//div[@id='nature']//img"));
        emojis.stream().forEach(t-> t.click());

        // parent iframe e geri donun
        driver.switchTo().defaultContent();
        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        //driver.findElement(By.xpath("//*[@id='text']")).sendKeys("Emre", Keys.TAB,"Smile");

        List<WebElement> texts = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> veriler = new ArrayList<>(Arrays.asList("Emre","Tatar","Selenium","Emre","Tatar","Selenium","Emre","Tatar","Selenium","Emre","Tatar"));

        for(int i = 0 ; i< texts.size() ; i ++){
            texts.get(i).sendKeys(veriler.get(i));
        }
        Thread.sleep(3000);
        //  apply button a basin
        driver.findElement(By.xpath("//button[@id='send']")).click();
        Thread.sleep(3000);


    }
}
