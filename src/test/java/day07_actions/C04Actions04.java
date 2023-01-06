package day07_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04Actions04 extends TestBase {

    @Test
    public void test01() {

//        Class: Action4
//        Method: dragAndDropTest
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0);//kaynak ve hedef iframe içinde olduğundan iframe geçiş yapmalıyız.
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();


    }
}
