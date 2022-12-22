package day02_junit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Assertions {
   static WebDriver  driver;

    @BeforeClass
    public  static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    //https://www.amazon.com adresine gidin
//Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
//=> Sayfa başlığının “Amazon” oldugunu test edin
//=> Amazon resminin görüntülendiğini (isDisplayed()) test edin
//Search Box 'in erisilebilir oldugunu test edin (isEnabled())
//wrongTitleTest  => Sayfa basliginin “amazon” olmadigini dogrulayin

    @Test
    public void titleTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test
    public void imageDisplayTest(){

        WebElement image = driver.findElement(By.id("nav-logo-sprites"));

        Assert.assertTrue(image.isDisplayed());

    }

    @Test
    public void searchBoxTest(){

        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void titleWrongTest(){

      String actualTitle =  driver.getTitle();
      String expectedTitle = "amazon";

      Assert.assertFalse(actualTitle.contains(expectedTitle));

    }

}



