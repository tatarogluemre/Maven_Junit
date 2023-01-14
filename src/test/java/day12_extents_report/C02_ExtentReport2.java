package day12_extents_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_ExtentReport2 extends TestBase {

    protected static ExtentTest extentTest;//Loglama yazdırma işlemi için
   protected static ExtentReports extentReports;//rapor oluşturma için
    protected  static  ExtentHtmlReporter extentHtmlReporter; //html raporu şablonlama

    @BeforeClass
    public static void extentReportsSetUp() {

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


    }

    @Test
    public void test01() {
        extentTest.pass("Pass");
        extentTest.info("Bilgilendirme Notu");
        extentTest.fail("Failed");
        extentTest.warning("Uyarı mesajı");
        extentTest.skip("Atlama mesajı");
        extentTest.fatal("Çöküş Hatası");


    }
    @AfterClass
    public static void extentReportsTearDown(){

        extentReports.flush();//raporlama işlemini oluşturur. Bu kullanılmazsa raporlama işlemi oluşmaz.

    }
}
