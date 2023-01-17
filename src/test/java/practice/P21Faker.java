package practice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P21Faker extends TestBase {
    @Test
    public void test01() {
/*
        - FAKER -
                Faker class'ı, adlar, telefon numaraları, adresler, SSN vb.
        gibi gerçek görünümlü verileri dinamik olarak oluşturmanıza olanak tanır.
                Web uygulamanızın bunları doğru bir şekilde kaydedeceğini bildiğiniz sürece,
        çoğu zaman ad veya adres gibi bu değerlerin ne olduğu umurunuzda olmaz ve faker kullanmak
        bu verileri modellemenize ve bu alanlar için şimdiye kadar test çalıştırması için yeni dinamik
        değerler oluşturmanıza olanak tanır.
        Faker class'ını kullanabilmemiz için mvn repository adresinden java faker kütüphanesini
        projemize eklememiz gerekmektedir.
                */
        //"https://demoqa.com/automation-practice-form"  Adresine gidin
        driver.get("https://demoqa.com/automation-practice-form");
        // Formu doldurunuz
        WebElement firstName = driver.findElement(By.id("firstName"));
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName(),
                Keys.TAB,faker.name().lastName(),
                Keys.TAB,faker.internet().emailAddress(),
                Keys.TAB,Keys.SPACE,
                Keys.TAB,faker.phoneNumber().cellPhone(),
                Keys.TAB,"17 Jan 1987",Keys.ENTER,
                Keys.TAB,Keys.ENTER,"e",Keys.ARROW_DOWN,Keys.ENTER,
                Keys.TAB,Keys.TAB,Keys.TAB,Keys.SPACE);
               String path = System.getProperty("user.home")+"/Desktop/logo.jpeg";
               driver.findElement(By.id("uploadPicture")).sendKeys(path);
               driver.findElement(By.id("currentAddress")).sendKeys(faker.address().fullAddress(),
                       Keys.TAB,"NCR",Keys.ENTER,Keys.TAB,"Delhi",Keys.ENTER);
        waitFor(3);
        // Sayfayi kapatin


    }
}
