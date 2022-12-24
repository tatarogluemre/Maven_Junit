package day03_handle_Dropdown;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {

    /*
1.What is dropdown?
Dropdown liste oluşturmak için kullanılır.
2.how to handle Dropdown elements
-dropdown locate edilir
-select objesi oluşturulur
-select objesi ile istenilen seçenek(selectByIndex()...)
3. Tüm dropdown seçeneklerini nasıl print ederiz.
-tüm dropdown elementlerini getOptions() methodu ile list e koyarız
-sonra seçenekleri loop ile yazdırabiliriz
4.Bir seçeneğin seçili olduğunu otamate etmek için ne yapılır
   ör: biz günü 10 olarak seçtik bunu seçilip seçilmediğini nasıl kontrol ederiz.
   getFirstSelectedOption() methodu ile automate edebilirz. ilk seçili olan seceneği return eder.
 */

    WebDriver driver;

    //Eğer test sınıfında birden fazla method oluşturulmuşsa before kullanılır.
    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test

    public void selectByIndexTest() {

        //Doğum yılını ayını ve gününü 2000,january,10 şeklinde seçer

        //1.Adım dropdown Locate et
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        //2.Adım Select objesi oluştur.
        Select yearSelect = new Select(year);
        //3.Adım select objesi kullanarak 3 farklı şekilde seçim yapılabilir.
        yearSelect.selectByIndex(22);//Seçenek sırası 0 dan başlar 0 ilk seçenek 2000 yılı 23.sırada
        //4.Adım Ay locate
        WebElement mounth = driver.findElement(By.id("month"));
        Select mounthSelect = new Select(mounth);
        mounthSelect.selectByValue("0");
        //5.Adım Gün Locate
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select daySelect = new Select(day);
        daySelect.selectByVisibleText("10");

    }

    @Test
    public void printAllList(){
        //Tüm eyaletleri print edelim
        WebElement state = driver.findElement(By.id("state"));
        Select selectState = new Select(state);
        List<WebElement> stateList = selectState.getOptions();
        for (WebElement w : stateList){
            System.out.println(w.getText());
        }
        //2.yol lambda
        stateList.stream().forEach(t-> System.out.println(t.getText()));
    }

@Test
    public void getSelectedOption(){

        //state dropdow daki varsayılan seçili seçeneğin select a state olduğunu verify edin

    WebElement state = driver.findElement(By.id("state"));
    Select stateSelect = new Select(state);
    String first = stateSelect.getFirstSelectedOption().getText();
    Assert.assertEquals("Select a State",first);
}

@After
    public void close(){

        driver.close();

}


}
