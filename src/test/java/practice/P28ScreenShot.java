package practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P28ScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
        String date="";
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        takeScreenShotOfPage();
        //Tüm sayfanın resmini alalım
//        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//         date= new SimpleDateFormat("dd-MM-yy-hh-mm-ss").format(new Date());
//        String path = System.getProperty("user.dir")+"/test-practice/screenshots/"+date+"img.png";
//        FileUtils.copyFile(image,new File(path));
        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        takeScreenShotOfPage();
//        waitFor(5);
//        File image2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        date= new SimpleDateFormat("dd-MM-yy-hh-mm-ss").format(new Date());
//        FileUtils.copyFile(image2,new File(path));
        //Tekrar amazon sayfasına dönüp iphone aratalım
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(0));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        WebElement search = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        takeScreenshotOfElement(search);
        //Arama sonucunun resmini alalım
//        waitFor(5);
//        date= new SimpleDateFormat("dd-MM-yy-hh-mm-ss").format(new Date());
//        WebElement search = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
//        File image2 = search.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(image2,new File(path));



    }
}
