package day07_actions;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03Actions03 extends TestBase {
    @Test
    public void test01() {
//        Class: ActionClass3
//        Method : scrollUpDown()
//        https://techproeducation.com a git
        driver.get("https://techproeducation.com");
//        Sayfanin altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        waitFor(3);
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN).perform();//daha az mesafe aldırır
        waitFor(3);
//        Sonra sayfanın üstüne doğru gidelim

        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(3);
        actions.sendKeys(Keys.ARROW_UP,Keys.ARROW_UP,Keys.ARROW_UP).perform();
        waitFor(3);
    }
}
