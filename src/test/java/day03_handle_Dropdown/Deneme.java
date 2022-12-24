package day03_handle_Dropdown;

import org.junit.Test;
import org.openqa.selenium.By;

public class Deneme extends C02_ReusableMethod{

    @Test
    public void selectMethod() throws InterruptedException {

        selectFromDropdown(driver.findElement(By.id("state")),"Arizona" );
        Thread.sleep(3000);

    }
}
