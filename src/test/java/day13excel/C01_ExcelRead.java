package day13excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class C01_ExcelRead {

    @Test
    public void test01() throws Exception {
//ADIMLAR:
//WORKBOOK > WORKSHEET > ROW (SATIR) >CELL(VERİ HÜCRESİ)

        String path = ".\\src\\test\\java\\resources\\Capitals.xlsx";

        //Dosyayı Aç
        FileInputStream fis = new FileInputStream(path);

        //1-Excel dosayasını aç /WORKBOOK
        Workbook workbook = WorkbookFactory.create(fis);
        //2-Sayfayı Aç /sheet1
        Sheet sheet1 = workbook.getSheet("Sheet1");
        //Sheet sheet1 = workbook.getSheetAt(0);  --> bu şekilde index de kullanabiliriz ancak isim kullanmak daha iyi
        //3-iLK SATIRA GİT /ROW
        Row row1 = sheet1.getRow(0); //il satıra git
        //4-İLK SATIRDAKİ İLK VERİYİ AL
        Cell cell1 = row1.getCell(0); //ilk hücredeki datayı al
        //5- O VERİYİ YAZDIR
        System.out.println(cell1);

        Cell cell2 = sheet1.getRow(0).getCell(1);
        System.out.println("cell2 = " + cell2);

        String data = readExcel("Sheet1",3,1);
        System.out.println(data);
        Assert.assertEquals("London",data);

        //Excel deki toplam satır sayısını bulma
        int toplamSatirSayisi = sheet1.getLastRowNum()+1;//son satır numarası index 0 dan başladığı için +1 ekliyoruz
        System.out.println("toplamSatirSayisi = " + toplamSatirSayisi);

        //Excelde kullanılan toplam satır sayısını bulma
        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();//bu index kullanmaz 1 den başlar.
        System.out.println("kullanilanToplamSatirSayisi = " + kullanilanToplamSatirSayisi);

        //COUNTRY, CAPITAL key ve value ları map e alıp print et

        Map<String,String> countriesCapitals = new HashMap<>();

       for(int satir =1 ; satir<kullanilanToplamSatirSayisi; satir++){

           String country = sheet1.getRow(satir).getCell(0).toString();
           String capital = sheet1.getRow(satir).getCell(1).toString();
           countriesCapitals.put(country,capital);

       }
        System.out.println(countriesCapitals);


    }

    public  String  readExcel(String sheet , int row , int cell) throws Exception {
        String path = "./src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(path);
        String data =  WorkbookFactory.create(fis).getSheet(sheet).getRow(row).getCell(cell).toString();
        return data;


    }

}
