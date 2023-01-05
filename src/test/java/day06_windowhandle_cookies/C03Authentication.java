package day06_windowhandle_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03Authentication extends TestBase {
    @Test
    public void authenticationTest01() {

//        https://the-internet.herokuapp.com/basic_auth sayfasina gidin
//        asagidaki yontem ve test datalarini kullanarak authentication’i yapin
//        URL              : https://username:password@URL
//        Username    : admin
//        password    : admin
//        Basarili sekilde sayfaya girin ve ‘Congratulations!’ yasizini doğrulayın

        //Authentication urlmiz : https://admin:admin@the-internet.herokuapp.com/basic_auth
                                        //username:password
                                  //bu şekil bize verilir.

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
       String actualText = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(actualText.contains("Congratulations"));
        wait(3);

    }
}
