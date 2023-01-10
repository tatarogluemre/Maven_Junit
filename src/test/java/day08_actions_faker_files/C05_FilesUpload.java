package day08_actions_faker_files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FilesUpload extends TestBase {
    @Test
    public void test01() {
//        https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
//        chooseFile butonuna basalim
        WebElement uploadButton = driver.findElement(By.id("file-upload"));
//        Yuklemek istediginiz dosyayi secelim.
        String filepath = System.getProperty("user.home")+"\\Desktop\\logo.jpeg";
        uploadButton.sendKeys(filepath);
//        Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
//        “File Uploaded!” textinin goruntulendigini test edelim.
        String uploadText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",uploadText);


    }
}
