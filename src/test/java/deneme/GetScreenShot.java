package deneme;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
        driver.get("https://google.com");
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDate = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/deneme/"+currentDate+"-image.png";
        FileUtils.copyFile(image,new File(path));
    }
    @Test
    public void test02() throws IOException {
        driver.get("https://google.com");
        WebElement logo = driver.findElement(By.xpath("//*[@alt='Google']"));
        File image = logo.getScreenshotAs(OutputType.FILE);
        String dateTime = new SimpleDateFormat("dd-MM-yy-hh-mm-ss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/deneme/"+dateTime+"_image.png";
        FileUtils.copyFile(image,new File(path));


    }
}
