package practice;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P04 {


    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

    }

    @AfterClass
    public static void tearDown() {
      driver.close();
    }
    @Test
    public void testPages() {

// http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
// Add Element butonuna 100 defa basınız
        WebElement button = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
       int counter=0;
        for(int i = 0 ; i<100 ; i++){
           button.click();
           counter++;
       }

// 100 defa basıldığını test ediniz
        Assert.assertTrue(counter==100);
        //counter kullanmadan 2.Yol
        List<WebElement> basmaSayisi = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(100,basmaSayisi.size());

// 90 defa delete butonuna basınız

        int counterd=0;
        for(int i = 0 ; i<90 ; i++){
            driver.findElement(By.xpath("(//*[@onclick='deleteElement()'])")).click();
            counterd++;
        }
// 90 defa basıldığını doğrulayınız
        Assert.assertTrue(counterd==90);
        List<WebElement> deleteSayisi = driver.findElements(By.xpath("//*[@onclick='deleteElement()'])"));
// Sayfayı kapatınız

    }
    }
