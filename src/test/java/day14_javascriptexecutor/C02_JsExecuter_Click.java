package day14_javascriptexecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_JsExecuter_Click extends TestBase {
    @Test
    public void test01() {

        //techproeducation.com sayfasına git
        driver.get("https://techproeducation.com");
        //LMS Login elementine tıkla
        clickByJs(driver.findElement(By.linkText("LMS LOGIN")));
        //Çıkan sayfanın url nin https://lms.techproeducation.com/ olduğunu doğrula
        String actualurl = driver.getCurrentUrl();
        String expectedurl = "https://lms.techproeducation.com/";
        Assert.assertEquals(expectedurl,actualurl);

    }
}
