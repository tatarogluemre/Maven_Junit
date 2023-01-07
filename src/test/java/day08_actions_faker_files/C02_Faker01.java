package day08_actions_faker_files;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_Faker01  {
    Faker faker;
    @Test
    public void test01() {
       //1.Adım faker objesi oluştur.
        faker = new Faker();
        //2.Adım Faker objesi ile fake data oluştur.

        //name datası
        String fname = faker.name().firstName();
        System.out.println("firstName = " + fname);

        //lastname datası
        String flastname = faker.name().lastName();
        System.out.println("lastName = " + flastname);

        //kullanıcı adı
        String username = faker.name().username();
        System.out.println("username = " + username);
        
        //meslek
        String fjob = faker.name().title();
        System.out.println("fjob = " + fjob);
        
        //şehir isimleri
        String fcity = faker.address().city();
        System.out.println("fcity = " + fcity);
        
        //full adress
        String fadress = faker.address().fullAddress();
        System.out.println("fadress = " + fadress);
        
        //cep numarası
        String fmobilenumber = faker.phoneNumber().cellPhone();
        System.out.println("fmobilenumber = " + fmobilenumber);
        
        //email
        String femail = faker.internet().emailAddress();
        System.out.println("femail = " + femail);
        
        //ratgele numara alma
        String frandomnumber = faker.number().digits(15);
        System.out.println("frandomnumber = " + frandomnumber);

        



    }
}
