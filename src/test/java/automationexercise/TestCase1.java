package automationexercise;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase1 {
    static WebDriver driver;

    @BeforeClass
    public  static void setUp(){

      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      driver.get("https://automationexercise.com/");
    }

    @AfterClass
    public static void afterClass() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();

    }

    @Test

    public void test01(){

        WebElement body = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(body.isDisplayed());
    }

   @Test
    public void test02(){

        driver.findElement(By.xpath("//*[@href='/login']")).click();

    }

    @Test
    public void test03(){

        WebElement visible = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(visible.isDisplayed());
    }

    @Test
    public void test04(){

        WebElement input =driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
        input.sendKeys("Emre", Keys.TAB,"tatar@gmail.com",Keys.TAB,Keys.ENTER);
    }

    @Test
    public void test05() {
    
    WebElement text = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
    Assert.assertTrue(text.isDisplayed());
    }

    @Test
    public void test06() {
       WebElement rd1= driver.findElement(By.id("id_gender1"));
       rd1.click();
       rd1.sendKeys(Keys.TAB,Keys.TAB,"12345",Keys.TAB,"7",Keys.TAB,"July",Keys.TAB,"1987",
               Keys.TAB,Keys.SPACE,Keys.TAB,Keys.SPACE);
    }

    @Test
    public void test07() {
        WebElement address = driver.findElement(By.id("first_name"));
        address.sendKeys("Trb",Keys.TAB,"Trr",Keys.TAB,"Techpro",Keys.TAB,"Yıld",Keys.TAB,"akç");
        WebElement country= driver.findElement(By.id("country"));
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("United States");
        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("Cadde",Keys.TAB,"Trb",Keys.TAB,"61000",Keys.TAB,"1221312431",Keys.TAB,Keys.ENTER);

    }

    @Test
    public void test08() {
        WebElement account = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(account.isDisplayed());

    }

    @Test
    public void test09() throws InterruptedException {

    driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();

    }

    @Test
    public void test10() {

    WebElement login = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
    Assert.assertTrue(login.isDisplayed());

    }

    @Test
    public void test11()  {

      driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
      WebElement delete = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
      Assert.assertTrue(delete.isDisplayed());

    }

    @Test
    public void test12() {

        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
       String actualUrl= driver.getCurrentUrl();
       Assert.assertEquals("https://automationexercise.com/",actualUrl);
    }
}
