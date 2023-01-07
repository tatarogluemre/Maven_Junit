package day08_actions_faker_files;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileExists {

    @Test
    public void isExists() {
        
        String userDir = System.getProperty("user.dir");//icindebulunulan klasörün yolunu (Path)verir
        System.out.println("userDir = " + userDir);
        
        String userHome = System.getProperty("user.home");//bilgisayarimizda bulunan user klasörünüverir
        System.out.println("userHome = " + userHome);

        //masaüstünde logo.jpeg varlığını test etme
        String dosyaYolu = userHome+"\\Desktop\\logo.jpeg";
        System.out.println("dosyaYolu = " + dosyaYolu);

        boolean isExists = Files.exists(Paths.get(dosyaYolu));
                           //Bilgisayarınızda dosyanın olup olmadığını kontroleder
                          // dosya varsa true yoksa false return eder.

        Assert.assertTrue(isExists);

    }
}
