package day07_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02Actions02 extends TestBase {
    @Test
    public void test01() {

//        Class: Actions2
//        Method : hoverOver() and test the following scenario:
//        Amazon a gidelim https://www.amazon.com/
           driver.get("https://www.amazon.com/");
//        Sag ust bolumde bulunan “Account & Lists” menüsüne git
        Actions actions = new Actions(driver);
        WebElement accountLists = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountLists).perform();
//        “Account” secenegine tikka
        WebElement accountLink = driver.findElement(By.xpath("//span[text()='Account']"));
        actions.click(accountLink).perform();
//        Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertEquals("Your Account",driver.getTitle());
        Assert.assertEquals("Your Account",driver.findElement(By.xpath("//div[@class='a-row a-spacing-base']")).getText());

    }
}
