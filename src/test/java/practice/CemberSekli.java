package practice;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class CemberSekli extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
//    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        Actions actions = new Actions(driver);
        actions.moveByOffset(660,345).build().perform();
        int y = 10;
        actions.clickAndHold().build().perform();
        for (int i=1; i<11; i++){
            actions.moveByOffset(i,-y).build().perform();
            y--;
        }
        for (int i=11; i>0; i--){
            actions.moveByOffset(i,-y).build().perform();
            y--;
        }
        for (int i=0; i>-11; i--){
            actions.moveByOffset(i,-y).build().perform();
            y++;
        }
        for (int i=-11; i<3; i++){
            actions.moveByOffset(i,-y).build().perform();
            y++;
        }
        waitFor(10);
    }
}
