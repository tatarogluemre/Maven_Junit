package practice;

import org.junit.*;
import org.junit.runner.OrderWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {
    /*  -"amazon.com" adresine gidelim
  -bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
  -title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
              -Ardindan "trendyol.com" adresine gidelim
  -bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
  -Bi onceki web sayfamiza geri donelim
  -sayfayi yenileyelim
  -Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim*/
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test

    public void title() {

        String title = driver.getTitle();
        System.out.println("title = " + title);
        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);
        Assert.assertFalse(url.contains("Spend"));
        Assert.assertTrue(title.contains("Spend"));

    }

    @Test

    public void trendyol(){

        driver.get("https://trendyol.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Sitesi"));

    }

    @Test
    public void navigate(){

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();


    }
}
