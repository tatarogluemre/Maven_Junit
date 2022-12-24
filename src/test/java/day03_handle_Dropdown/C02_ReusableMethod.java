package day03_handle_Dropdown;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ReusableMethod {

    WebDriver driver;
    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    //REUSABLE METHOD: Dropdown için tekrar tekrar kullanabileceğimiz methodlar oluşturalım.

    public void selectFromDropdown(WebElement dropdown , String secenek){

        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        for(WebElement w : options){

            if(w.getText().equals(secenek)){
                w.click();
                break;
            }
        }

    }
   @Test
   public void selectFromDropdown(){

    selectFromDropdown(driver.findElement(By.id("year")),"2005");



   }





}
