package day10_exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

public class C03_NullPointerExceptions  {

    /*
    Değişkenleri oluşturup instantiate yani =new yapıp değer atama yapmadan değişkenleri kullanırsak nullpointer alırız.
    ör: WebDriver driver;
    driver.get("https://google.com")
    Çözüm :
          Değişkenleri =new ile değer atama yapma

     */
WebDriver driver;
Faker faker;
    @Test
    public void test01() {

    driver.get("https://google.com");
    }

    @Test
    public void test02() {
        System.out.println(faker.name().firstName());


    }
}
