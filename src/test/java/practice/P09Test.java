package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P09Test extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //    accept Alert(I am an alert box!) and print alert on console
        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        //    cancel Alert  (Press a Button !)
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).sendKeys(Keys.ENTER,Keys.TAB,Keys.ENTER);
        Thread.sleep(3000);
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Emre");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        //    finally print on console this message "Hello TechproEducation How are you today"

         String actualmessage = driver.findElement(By.id("demo1")).getText();
        System.out.println("actualmessage = " + actualmessage);
        Thread.sleep(3000);
        //    aseertion these message
        Assert.assertTrue(actualmessage.contains("Emre"));

    }
}
