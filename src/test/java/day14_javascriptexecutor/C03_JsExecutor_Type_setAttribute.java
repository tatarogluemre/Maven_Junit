package day14_javascriptexecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JsExecutor_Type_setAttribute extends TestBase {
    @Test
    public void test01() {
        //techproeducation.com sayfasına git
        driver.get("https://techproeducation.com");
        //type test methodu oluştur QA yaz
        WebElement search =driver.findElement(By.xpath("//input[@type='search']"));
        typeWithJs(search,"QA");
        waitFor(3);

    }
}
