package homework;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import net.bytebuddy.pool.TypePool;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class HWFaker extends TestBase {

    @Test
    public void test01(){

        //Faker Kutuphanesi HOMEWORK
//Faker class'i testlerimizi yaparken ihtiyaç duydugumuz isim, soyisim, adres vb bilgiler icin fake
//degerler uretmemize imkan tanir.
//Faker degerler uretmek icin Faker class'indan bir obje uretir ve var olan method'lari kullaniriz.
//"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
//"create new account"  butonuna basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        Faker faker = new Faker();
        String name = faker.name().firstName();
        String lastname = faker.name().lastName();
        String mail = faker.internet().emailAddress();
        String password = faker.internet().password();

//"firstName" giris kutusuna bir isim yazin
driver.findElement(By.name("firstname")).
        sendKeys(name, Keys.TAB,lastname,
                Keys.TAB,mail,Keys.TAB);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailconfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_email_confirmation__")));
emailconfirm.sendKeys(mail,Keys.TAB,password,Keys.TAB,
                Keys.TAB,"1",Keys.TAB,"T",Keys.TAB,"1111",Keys.TAB,Keys.TAB,Keys.ARROW_RIGHT,Keys.SPACE);
        WebElement kadin = driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertFalse(kadin.isSelected());
        waitFor(3);
        driver.findElement(By.name("websubmit")).click();
        waitFor(8);


//"surname" giris kutusuna bir soyisim yazin
//"email" giris kutusuna bir email yazin
//"email" onay kutusuna emaili tekrar yazin
//Bir sifre girin
//Tarih icin gun secin
//Tarih icin ay secin
//Tarih icin yil secin
//Cinsiyeti secin
//Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
//Sayfayi kapatin
    }
    //Faker Kutuphanesi HOMEWORK
//Faker class'i testlerimizi yaparken ihtiyaç duydugumuz isim, soyisim, adres vb bilgiler icin fake
//degerler uretmemize imkan tanir.
//Faker degerler uretmek icin Faker class'indan bir obje uretir ve var olan method'lari kullaniriz.
//"https://facebook.com"  Adresine gidin
//"create new account"  butonuna basin
//"firstName" giris kutusuna bir isim yazin
//"surname" giris kutusuna bir soyisim yazin
//"email" giris kutusuna bir email yazin
//"email" onay kutusuna emaili tekrar yazin
//Bir sifre girin
//Tarih icin gun secin
//Tarih icin ay secin
//Tarih icin yil secin
//Cinsiyeti secin
//Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
//Sayfayi kapatin

}
