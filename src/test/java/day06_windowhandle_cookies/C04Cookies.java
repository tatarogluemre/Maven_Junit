package day06_windowhandle_cookies;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04Cookies extends TestBase {

    @Test
    public void cookiesTest() {

//        Class: Cookies
//        Method: handleCookies
//        Amazona git
        driver.get("https://amazon.com");
//        1.toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println("Tüm cookie sayısı "+allCookies.size());
//        3. Bir Cookie yi ismiyle bul

        allCookies.stream().forEach(t-> System.out.println(t.getName()));

        for(Cookie w : allCookies){
            System.out.println("Cookie : "+w);
            System.out.println("Cookie İsimleri = "+w.getName());
        }
        System.out.println("Çağrılan Cookie : "+driver.manage().getCookieNamed("sp-cdn"));
//        4. Yeni bir cookie ekle
            Cookie favoriCookie = new Cookie("cikolatam","antepfistik");
            driver.manage().addCookie(favoriCookie);
            waitFor(3);
        System.out.println(driver.manage().getCookieNamed("cikolatam"));
//        5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("csm-hit");
//        6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        Set<Cookie> son = driver.manage().getCookies();
        System.out.println("Silindikten sonra cookie sayısı " +son.size());


    }
}
