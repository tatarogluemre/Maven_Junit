package day06_windowhandle_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02WindowHandleNewWindow extends TestBase {

    @Test
    public void newWindowHandleTest() {

        //1.Techproeducation sayfasının titleinın Techpro Education metnini içerdiğini test edin
        driver.get("https://techproeducation.com");
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        //2.Yeni bir pencerede amazon sayfasını açın titlenin Amazon içerdiğini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        //3.Yeni bir pencerede lindein sayfasını açıp title'ının  Linkedin metnini içerdiğini test edin.
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        //Techpro Education penceresine dönelim
        switchToWindow(1);
        waitFor(2);

    }
}
