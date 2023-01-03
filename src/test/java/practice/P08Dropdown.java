package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class P08Dropdown extends TestBase {

    @Test
    public void test01(){
    //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //dropdown menudeki tüm web elemntleri yazdıralım
       List<WebElement> dropdown =  driver.findElements(By.id("searchDropdownBox"));
        dropdown.forEach(t-> System.out.println(t.getText()));
        //dropdown menüden baby seçelim
        //arama bölümünden milk aratalım
       // driver.findElement(By.id("searchDropdownBox")).sendKeys("Baby", Keys.TAB,"Milk",Keys.ENTER);

        WebElement selectBoxs= driver.findElement(By.id("searchDropdownBox"));
        Select selects = new Select(selectBoxs);
        List<WebElement>drp = selects.getOptions();
        for(int i = 0 ; i< drp.size(); i++){
           WebElement selectBox= driver.findElement(By.id("searchDropdownBox"));
            Select select = new Select(selectBox);
            select.selectByIndex(i);
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Baby", Keys.ENTER);
            driver.navigate().back();

       }


    }
}
