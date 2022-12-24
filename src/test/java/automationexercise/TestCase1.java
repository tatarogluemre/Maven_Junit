package automationexercise;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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



    @Test

    public void pageVisible(){

        WebElement body = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(body.isDisplayed());
    }

   @Test
    public void clickSignUp(){

        driver.findElement(By.xpath("//*[@href='/login']")).click();

    }

    @Test
    public void NewUserSignupisVisible(){

        WebElement visible = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(visible.isDisplayed());
    }



}
