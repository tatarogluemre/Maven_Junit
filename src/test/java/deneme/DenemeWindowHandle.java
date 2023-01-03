package deneme;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitiesdeneme.TestDeneme;

import java.util.Set;

public class DenemeWindowHandle extends TestDeneme {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
       String window1 = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
       driver.findElement(By.linkText("Click Here")).click();
       for(String w : handles){

           if(!w.equals(window1)){
               driver.switchTo().window(w);
               break;
           }
       }
       String window2 = driver.getWindowHandle();
        Thread.sleep(3000);
       driver.switchTo().window(window1);
        Thread.sleep(3000);
        driver.switchTo().window(window2);
    }

    @Test
    public void test02() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();

        selectWindow("The Internet");
        Thread.sleep(3000);
        selectWindow("New Window");
        Thread.sleep(3000);
        selectWindow("The Internet");
        Thread.sleep(3000);
        selectWindow("New Window");
        Thread.sleep(3000);

    }
}
