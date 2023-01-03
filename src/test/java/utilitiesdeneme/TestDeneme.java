package utilitiesdeneme;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public abstract class TestDeneme {
    public static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }

    public void selectDropdown(WebElement dropdown , String secenek){

        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        for(WebElement w : options){

            if(w.getText().equals(secenek)){
                w.click();
                break;
            }


        }
    }


    public void selectWindow(String windowTitle){

        String orgin = driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();

        for(String w : handles){
            driver.switchTo().window(w);
            if(!driver.getTitle().equals(windowTitle)){
                return;
            }

        }

        driver.switchTo().window(orgin);
    }

}
