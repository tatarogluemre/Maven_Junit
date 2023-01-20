package day14_javascriptexecutor;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Js_GetValue extends TestBase {
    @Test
    public void test01() {

//      1)getValueTest metotu olustur
//	    2)https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");
//      3)Tarih kısmındaki Yazili metinleri al ve yazdır
        getValueByJs("hotelDates");

    }




}
