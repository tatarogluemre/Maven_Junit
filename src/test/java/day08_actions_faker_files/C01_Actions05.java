package day08_actions_faker_files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Actions05 extends TestBase {

    @Test
    public void test01() {

//        Google a gidin https://www.google.com
        driver.get("https://www.google.com");
//      ‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
////        Ve ENTER tusuna bas
        WebElement searchBox = driver.findElement(By.name("q"));
        actions.keyDown(searchBox, Keys.SHIFT). //shift tusuna basılı tutunca harfleri büyük yazar
                sendKeys("iphone x fiyatları").
                keyUp(searchBox,Keys.SHIFT).//keyDown() methodundan sonra keyUp() kullanılmalıdır.
                sendKeys(" Çok pahalı",Keys.ENTER).
                build().//çoklu actions method kullnımında build kullanmak iyiydir.
                perform();

    }
}
