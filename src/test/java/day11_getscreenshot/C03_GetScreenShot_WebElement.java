package day11_getscreenshot;

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

public class C03_GetScreenShot_WebElement extends TestBase {
    @Test
    public void test01() throws IOException {
//        Techpro education a git
        driver.get("https://techproeducation.com");
//        Sosyal medya elemanlarını goruntusunu al
        WebElement sosyalMedyaIcons= driver.findElement(By.xpath("//*[@data-id='d7545f2']"));
        File image = sosyalMedyaIcons.getScreenshotAs(OutputType.FILE);
        String currentTime =new SimpleDateFormat("yyyy-MM-dd-hh-ss").format(new Date());
        //Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));
    }


    }

