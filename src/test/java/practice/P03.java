package practice;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testpages.herokuapp.com/styled/index.html");

    }

    @AfterClass
    public static void tearDown() {
     driver.close();
    }
@Test
    public void testPages(){

    // Navigate to  https://testpages.herokuapp.com/styled/index.html
// Click on  Calculate under Micro Apps
    driver.findElement(By.id("calculatetest")).click();

//    Type any number in the first input
    driver.findElement(By.id("number1")).sendKeys("123456",
            Keys.TAB,"minus",
            Keys.TAB,"234",
            Keys.TAB,Keys.ENTER);
//    Type any number in the second input
// Click on Calculate
// Print the result
    System.out.println(driver.findElement(By.id("answer")).getText());
    System.out.println(driver.findElement(By.cssSelector("span[id='answer']")).getText());
// close driver



}


}
