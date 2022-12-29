package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {

     /*
       https://www.google.com/ adresine gidin
       cookies uyarisini kabul ederek kapatin
       Sayfa basliginin “Google” ifadesi icerdigini test edin
       Arama cubuguna “Nutella” yazip aratin
       Bulunan sonuc sayisini yazdirin
       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       Sayfayi kapatin
     */

        driver.get("https://google.com");

        String title = driver.getTitle();

        Assert.assertTrue(title.contains("Google"));
    }

    @Test
    public void test02()

    {
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        String text = driver.findElement(By.id("result-stats")).getText();

        String arr[] = text.split(" ");

        System.out.println("Nutella arama Sonucu : " + arr[1]);

        int sonuc = Integer.parseInt(arr[1].replace(".", ""));

        Assert.assertTrue(sonuc > 10000000);

        driver.close();

    }
}
