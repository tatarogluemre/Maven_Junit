package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P15Actions extends TestBase {
    @Test
    public void test01() {

//        http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get(" http://uitestpractice.com/Students/Actions");
//        Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        Actions action = new Actions(driver);
        WebElement maviKutu = driver.findElement(By.id("div2"));
        action.moveToElement(maviKutu).perform();
        waitFor(4);
//        Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement doubleclickButton = driver.findElement(By.xpath("//button[@name='dblClick']"));
        action.doubleClick(doubleclickButton).perform();
        String text = driver.switchTo().alert().getText();
        Assert.assertEquals("Double Clicked !!",text);
//        Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();
//        Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
       WebElement drag = driver.findElement(By.id("draggable"));
       WebElement drop = driver.findElement(By.id("droppable"));
       action.dragAndDrop(drag,drop).perform();
       String actualtext=driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        Assert.assertEquals("Dropped!",actualtext);
    }
}
