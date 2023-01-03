package deneme;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestDeneme extends utilitiesdeneme.TestDeneme {

    @Test

    public void test01(){

        driver.get("https://amazon.com");
        WebElement searchByCategory = driver.findElement(By.id("searchDropdownBox"));
        selectDropdown(searchByCategory,"Automotive");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Antifreeze", Keys.ENTER);

        List<WebElement> images = driver.findElements(By.xpath("//*[@class='s-image']"));

        for(int i=0 ; i<images.size() ; i++){
            List<WebElement> image = driver.findElements(By.xpath("//*[@class='s-image']"));
             image.get(i).click();
            System.out.println((i+1)+". Resim = "+driver.getTitle());
             driver.navigate().back();

        }


    }
@Test
    public void test02(){

       WebElement select =  driver.findElement(By.id("searchDropdownBox"));
    Select searchCategory = new Select(select);
    searchCategory.selectByVisibleText("Baby");
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bicycle",Keys.ENTER);

}
    @Test
    public void test03(){
        driver.get("https://amazon.com");
        WebElement select =  driver.findElement(By.id("searchDropdownBox"));
        Select searchCategory = new Select(select);
        List<WebElement> searchBoxElements = searchCategory.getOptions();

        for(int i = 0; i<searchBoxElements.size() ; i++){
            WebElement selectCategory =  driver.findElement(By.id("searchDropdownBox"));
            Select category = new Select(selectCategory);
            category.selectByIndex(i);
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bicycle",Keys.ENTER);
            driver.navigate().back();



        }



    }

}
