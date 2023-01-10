package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P16BuyukKucukHarf extends TestBase {
    @Test
    public void test01() {

        //google sayfasına gidelim
        driver.get("https://google.com");
        //Büyük küçük harf olacak şekilde HeLlO yazdırıp aratalım
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));

        String hello = "hello";
        String[]arr = hello.split("");

        for(int i = 0 ; i<arr.length ; i++){
            if(i%2==0){
                searchBox.sendKeys(Keys.SHIFT,arr[i]);
            }else  searchBox.sendKeys(arr[i]);

        }



    }
}
