package day06_windowhandle_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01WindowHandleReusableMethod extends TestBase {


    @Test
    public void test01() {
   //      https://the-internet.herokuapp.com/windows adresine gidin.
           driver.get(" https://the-internet.herokuapp.com/windows");
           String window1 = driver.getWindowHandle();
  //        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText = driver.findElement(By.xpath("//*[.='Opening a new window']")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(actualText,expectedText);
 //        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals(driver.getTitle(),"The Internet");
//        Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        wait(3);
        //İkinci pencere açılır ve ikinci pencerede işlem yapmak istediğimden o pencereye switch geçiş yapmalıyız.
            switchToWindow(2);

//        Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            String actualTitle = driver.getTitle();
            String expectedTitle = "New Window";
            Assert.assertEquals(actualTitle,expectedTitle);
    }
}
