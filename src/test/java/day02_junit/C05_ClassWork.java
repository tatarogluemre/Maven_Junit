package day02_junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After

    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


    @Test

    public void test01() {

        //Verilen web sayfasına gidin.
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //https://the-internet.herokuapp.com/checkboxes
        //Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement c1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement c2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        //Checkbox1 seçili değilse onay kutusunu tıklayın

        if (!c1.isSelected()) {
            c1.click();
        }
        //Checkbox2 seçili değilse onay kutusunu tıklayın

        if (!c2.isSelected()) {
            c2.click();
        }
    }

    @Test
    public void test02() throws InterruptedException {

        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //Cookies’i kabul edin
        //“Create an Account” button’una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        //“radio buttons” elementlerini locate edin
        WebElement kadin = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        WebElement erkek = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        WebElement ozel = driver.findElement(By.xpath("(//*[@type='radio'])[3]"));
        //Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(3000);
        if (!erkek.isSelected()) {
            erkek.click();
        }

    }

}

