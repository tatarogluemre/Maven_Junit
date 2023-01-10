package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P17Actions02 extends TestBase {

    @Test
    public void test01() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        //Alerts, Frame & Windows Butonuna click yap
        WebElement button = driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[3]"));
        actions.sendKeys(Keys.PAGE_DOWN);
        actions.moveToElement(button).perform();
        button.click();
        waitFor(3);
        //clickWithText("div.card-body>h5","Alerts, Frame & Windows");
        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        String text = driver.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']")).getText();
        Assert.assertEquals("Please select an item from left to start practice.",text);
        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap

         WebElement asd = driver.findElement(By.xpath("//*[text()='Browser Windows']"));
         actions.sendKeys(Keys.PAGE_DOWN).perform();
         actions.moveToElement(asd).perform();
         asd.click();
        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab = driver.findElement(By.id("tabButton"));
        Assert.assertTrue(newTab.isDisplayed());
        //New Tab butonuna click yap
        newTab.click();
        waitFor(2);
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        switchToWindow(2);
        String textSample = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals("This is a sample page",textSample);
        //İlk Tab'a geri dön
        switchToWindow(1);
        waitFor(2);
        ////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(newTab.isDisplayed());

    }
}
