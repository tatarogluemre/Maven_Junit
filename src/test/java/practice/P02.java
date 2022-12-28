package practice;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

    @Test

    public void title() {
        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
//fill the firstname
       WebElement firstname= driver.findElement(By.xpath("//*[@name='firstname']"));
       firstname.sendKeys("Emre",Keys.TAB,"Tatar",Keys.TAB,Keys.SPACE,Keys.TAB,
               Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT,Keys.TAB, "27.12.22",Keys.TAB,Keys.TAB,
               Keys.SPACE,Keys.TAB,Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB,"Europe",
               Keys.TAB,Keys.ARROW_DOWN,Keys.CONTROL,Keys.ARROW_DOWN,Keys.SPACE);
//fill the lastname

//check the gender

//check the experience
//fill the date
//choose your profession -> Automation Tester
//choose your tool -> Selenium Webdriver
//choose your continent -> Antartica
//choose your command  -> Browser Commands
//click submit button


    }

}
