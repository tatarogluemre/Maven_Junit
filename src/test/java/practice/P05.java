package practice;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {
    //BeforeClass ile driver ı olusturun ve
//Maximize edin, 15 sn bekletin
//http://www.google.com adresine gidin
//arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
//arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
//arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
//AfterClass ile kapatın
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Before
    public void setUpp()  {
        driver.get("http://google.com");
    }

    @After
    public void tearDownn()  {
        String sonuc = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        String arr[] = sonuc.split(" ");
        System.out.println("Sonuc : "+ arr[1]);

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {

        arama("The God Father");

    }

    @Test
    public void test02() {

     arama("KillBill");

    }
    @Test
    public void test03() {

        arama("Lord Of The Rings");

    }

    public void arama(String ara){

        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys(ara, Keys.ENTER);


    }
}
