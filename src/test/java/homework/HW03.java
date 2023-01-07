package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class HW03   extends TestBase {
    @Test
    public void test01() {
//    Test01 :  1- amazon gidin
        driver.get("https://amazon.com");
//    Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);
        List<WebElement> dropdownElemnts =  select.getOptions();
        dropdownElemnts.stream().forEach(t-> System.out.println(t.getText()));
//    dropdown menude 40 eleman olduğunu doğrulayın
        System.out.println(dropdownElemnts.size());
       boolean dropdownElementsCount = dropdownElemnts.size() == 28;
        Assert.assertTrue(dropdownElementsCount);

//            Test02
//    dropdown menuden elektronik bölümü seçin
       selectDropdown(dropdown,"Electronics");
//    arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
//    sonuc sayisi bildiren yazinin iphone icerdigini test edin
    String actualText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
    Assert.assertTrue(actualText.contains("iphone"));
//    ikinci ürüne relative locater kullanarak tıklayin
      WebElement second =  driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//img[@data-image-index='2']"));
        second.click();
      //    ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        WebElement fiyat = driver.findElement(By.xpath("//*[@class='a-section a-spacing-micro']"));
        System.out.println(fiyat.getText());
        System.out.println(driver.getTitle());
        driver.findElement(By.id("add-to-cart-button")).click();
//    Test03
//    yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
//    dropdown’dan bebek bölümüne secin
        selectDropdown(driver.findElement(By.id("searchDropdownBox")),"Baby");
//    bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("puset", Keys.ENTER);
//    sonuç yazsının puset içerdiğini test edin
        String actualText2 = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(actualText2.contains("puset"));
//    üçüncü ürüne relative locater kullanarak tıklayin

//    title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

//    Test 4
//    1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

}


//    Bir Class olusturalim KeyboardActions2
//    https://html.com/tags/iframe/ sayfasina gidelim
//    video’yu gorecek kadar asagi inin
//    videoyu izlemek icin Play tusuna basin
//    videoyu calistirdiginizi test edin



//    Keyboard Base Actions
//            Homework
//    Yeni Class olusturun ActionsClassHomeWork
//    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
//    2- Hover over Me First" kutusunun ustune gelin
//    Link 1" e tiklayin
//    Popup mesajini yazdirin
//    Popup'i tamam diyerek kapatin
//    “Click and hold" kutusuna basili tutun
//    7-“Click and hold" kutusunda cikan yaziyi yazdirin
//    8- “Double click me" butonunu cift tiklayin


}
