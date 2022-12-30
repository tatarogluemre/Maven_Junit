package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class HW02 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

//    https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
//    Title in ‘Windows’ oldugunu test edin
        String window1ActualTitle = driver.getTitle();
        Assert.assertEquals("Windows",window1ActualTitle);
//    Click here a tiklayin
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);
//    Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        switchToWindow("New Window");
        String window2ActualTitle = driver.getTitle();
        Assert.assertEquals("New Window",window2ActualTitle);
        Thread.sleep(2000);
        switchToWindow("Windows");

        //2.Yol
        String window1Handle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for(String w : handles){
            if(!w.equals(window1Handle)){
                driver.switchTo().window(w);
                break;
            }
        }
        String window2 = driver.getWindowHandle();
        String window2Title = driver.getTitle();
        Assert.assertEquals("New Window",window2Title);
        Thread.sleep(2000);
        switchWindowMethod("Windows");
        String window1Title=driver.getTitle();
        System.out.println("window1Title = " + window1Title);
        Assert.assertEquals("Windows",window1Title);
        Thread.sleep(4000);


    }
public static void switchWindowMethod(String title){

    String windowHandle = driver.getWindowHandle();
    Set<String> handles = driver.getWindowHandles();
    for(String w : handles){
        driver.switchTo().window(w);
        if(driver.getTitle().equals(title)){
            return;
        }
    }

    driver.switchTo().window(windowHandle);

}


}
