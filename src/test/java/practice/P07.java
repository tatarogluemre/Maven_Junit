package practice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P07 {
        /*
        - ebay sayfasına gidiniz
        - electronics bölümüne tıklayınız
        - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        - Her sayfanın sayfa başlığını yazdıralım
        - sayfayı kapatalım
         */
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
            //- ebay sayfasına gidiniz
            driver.get("https://ebay.com");
            //- electronics bölümüne tıklayınız
            driver.findElement(By.xpath("(//a[text()='Electronics'])[2]")).click();
            //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım

            List<WebElement> resimlerr = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));

            for(int i=0; i< resimlerr.size() ; i++){
                List<WebElement> resimler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
                resimler.get(i).click();
                System.out.println((i+1)+". Başlık : "+ driver.getTitle());
                driver.navigate().back();
            }

            //- Her sayfanın sayfa başlığını yazdıralım
            //- sayfayı kapatalım
        }
    }

