package deneme;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Test01 {
    static WebDriver driver;
   @BeforeClass

    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
        driver.navigate().refresh();

    }

    @Test

    public void checkWebsiteLogo() {

        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }


    public void searchByCategory(WebElement dropdown, String sec) {

        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        for (WebElement w : options) {
            if (w.getText().equals(sec)) {
                w.click();
                break;
            }
        }

    }

    @Test
    public void selectCategoryAndSearchText() {

        searchByCategory(driver.findElement(By.id("searchDropdownBox")), "Automotive");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Antifreeze", Keys.ENTER);

        String result = driver.findElement(By.className("sg-col-inner")).getText();
        String rst[] = result.split(" ");
        System.out.println("Antifreeze Arama Sonucu = " + rst[2]);

        List<WebElement>firstImage = driver.findElements(By.className("s-image"));
        firstImage.get(0).click();

    }


}
