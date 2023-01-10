package practice;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P14Cookies extends TestBase {

    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */

    @Test
    public void test01() {
        //Techproeducation adresine gidiniz
        driver.get("https://techproeducation.com");
        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies = driver.manage().getCookies();
        int cookiesSayısı = cookies.size();
        System.out.println("cookiesSayısı = " + cookiesSayısı);
        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        cookies.stream().forEach(t-> System.out.println(t.getName()+": "+ t.getValue()));
        //Yeni bir cookie ekleyiniz
        for(int i= 0 ; i<10 ; i++){
        Cookie mycookie = new Cookie("musallat"+i,"404"+i);
        driver.manage().addCookie(mycookie);}
        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie> cookies2 = driver.manage().getCookies();
        int cookiesSayısı2 = cookies2.size();
        System.out.println("cookiesSayısı = " + cookiesSayısı2);
        cookies2.stream().forEach(t-> System.out.println(t.getName()+": "+ t.getValue()));
        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookieNamed("musallat");
        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
        Set<Cookie> cookiesDelete = driver.manage().getCookies();
        System.out.println(cookiesDelete.size());



    }
}
