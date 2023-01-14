package day12_extents_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReports extends TestBase {

    /*
    Hatırlamamız gereken 3 class
     */
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;
    @Test
    public void test01() {

        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";
//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

//     **********************RAPORU CUSTOMIZE EDEBİLİRİZ*****************************
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Applications","Techpro");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Takım","Eagles");
        extentReports.setSystemInfo("Epic","Ödeme Sayfası");
        extentReports.setSystemInfo("Sprint-No:","Sprint-145");
        extentReports.setSystemInfo("QA:","Emre");

//    **********************EXTRA RAPOR VE DÖKÜMAN İSMİ EKLEYEBİLİRİZ******************
        extentHtmlReporter.config().setDocumentTitle("Techpro Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");

 //   ************************RAPOR AYARLARI BİTTİ*************************************
       //RAPORU PROJEME EKLİYORUM
       extentReports.attachReporter(extentHtmlReporter);

       //EXTENT TEST OBJESİ OLUŞTURDUK
       extentTest = extentReports.createTest("Extent Report Login Test","Smoke Test");

       //TÜM AYARLAR BİTTİ EXTENT TEST OBJESİ İLE LOGLAMA (RAPORA YAZDIRMA) İŞLEMİNİ YAPABİLİRİZ.
        extentTest.pass("Kullanıcı anasayfaya gider");
        driver.get("https://techproeducation.com");

        //lms sayfasına gidelim
        extentTest.pass("Kullanıcı LMS Sayfasına gider");
        driver.findElement(By.linkText("LMS LOGIN")).click();

        //TEST BİTTİ
        extentTest.pass("TEST BAŞARYLA GERÇEKLEŞTİ");

       //

        extentReports.flush();

    }
}
