package day11_getscreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_GetScreenShot_FullScreen extends TestBase {
    /*
    Seleniumtüm ekran görüntüsü nasıl alınır
     -tüm ekran görüntüsü seleniumdan gelen getScreenshotAs metodu ile alınır.
     -tüm ekran görüntüsü getScreenshotAs metodu TakeScreenShot api si ile kullanılır.
     */



    @Test
    public void test01() throws IOException {

//        Class : screenShot1
//        Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://techproeducation.com");
//
       //1- Ekran görüntüsünü getScreenshotAs metodu ile alip File olarak oluşturalım.
        File goruntu = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //2-Almış olduğumuz ekran görüntüsünü belirlediğimiz dosyaya belirlediğimiz dinamik isim ile kaydet.
        String currentDate = new SimpleDateFormat("yyyy-MM-dd-ss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/EkranAlintilari/"+currentDate+"image.png";
        File hedef = new File(path);
        //3-Görüntü ile dosyayı birleştirip kaydedeceğiz
        FileUtils.copyFile(goruntu,hedef);

        //-“QA” aramasi yap
        driver.findElement(By.xpath("//input[@class='elementor-search-form__input']")).sendKeys("QA", Keys.ENTER);
//        Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
        String actualText=driver.findElement(By.xpath("//*[contains(text(),'Search Results for:')]")).getText();
        String expectedText="Search Results for: QA";
        Assert.assertTrue(expectedText.equals(actualText));
        //4-Ekran görüntüsünü Test Base deki REUSABLE metodu ile al
        takeScreenShotOfPage();

    }

    @Test
    public void test02() throws IOException {
         driver.get("https://techproeducation.com");
        //Logonun ekran görüntüsünü alma
        WebElement logo = driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
        //webElement reusable metod ile logo resmini alma
        takeScreenshotOfElement(logo);

    }



}
