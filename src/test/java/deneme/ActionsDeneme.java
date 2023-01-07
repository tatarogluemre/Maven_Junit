package deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsDeneme extends TestBase {
    @Test
    public void test01() {

//  #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
// #Fill in capitals by country
       for(int i =1 ; i<8 ; i++){
           WebElement source = driver.findElement(By.id("box"+i));
           WebElement target = driver.findElement(By.id("box"+(100+i)));
           Actions actions = new Actions(driver);
           actions.dragAndDrop(source,target).perform();
       }

    }

    @Test
    public void test02() {

        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hover1 = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hover1).perform();
        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. "Click and hold" kutusuna basili tutun
        WebElement clickHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickHold).perform();
        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickHold.getText());
        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClck = driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClck).perform();
        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        WebElement dblClk = driver.findElement(By.xpath("//*[@class='div-double-click double']"));
        System.out.println(dblClk.getText());
        Assert.assertTrue(dblClk.isEnabled());

    }
    @Test
    public void hoverOverTest() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.xpath("//button[.='Hover Over Me First!']"))).perform();

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[.='Link 1'])[1]")).click();

        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleButton = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleButton).perform();

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        WebElement yesil =    driver.findElement(By.xpath("//*[@class='div-double-click double']"));
        Assert.assertTrue(yesil.isEnabled());
    }
}
