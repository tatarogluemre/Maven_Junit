package day07_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04Actions05 extends TestBase {

    @Test
    public void test01() {

//        Method: dragAndDropTest
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0);//kaynak ve hedef iframe içinde olduğundan iframe geçiş yapmalıyız.
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).//kaynağı tut
                moveToElement(target).//hedefe taşı
                release().//kaynağa bırak
                perform(); //işlemi gerçekleştir.

    }

    @Test
    public void test02() {

//        Method: moveByOfset() belirli kordinata sürükleme
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0);//kaynak ve hedef iframe içinde olduğundan iframe geçiş yapmalıyız.
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveByOffset(460,-17).release().perform();



    }
}