package day13excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void test01() throws IOException {
        //Adımlar
        //WORKBOOK > SHEET > ROW > CELL > YAZ > KAYDET
        String path = ".\\src\\test\\java\\resources\\Capitals.xlsx";

        //Dosyayı Aç
        FileInputStream fis = new FileInputStream(path);

        //1-Excel dosayasını aç /WORKBOOK
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.getSheet("Sheet1").getRow(0).createCell(3).setCellValue("Bölge");
        workbook.getSheet("Sheet1").getRow(1).createCell(3).setCellValue("America");
        //2-Sayfayı Aç /sheet1
        Sheet sheet1 = workbook.getSheet("Sheet1");
        //Sheet sheet1 = workbook.getSheetAt(0);  --> bu şekilde index de kullanabiliriz ancak isim kullanmak daha iyi
        //3-iLK SATIRA GİT /ROW
        Row row1 = sheet1.getRow(0); //il satıra git
        //4- İLK SATIR 3. SUTUNU CREATE ET
        Cell cell3 = row1.createCell(2);
        //5-Nufus yazdır.
        cell3.setCellValue("NUFUS");

//       sheet1.getRow(1).createCell(2).setCellValue(35000);
//       sheet1.getRow(2).createCell(2).setCellValue(45000);
//       sheet1.getRow(3).createCell(2).setCellValue(55000);
        for(int i = 1 ; i<sheet1.getPhysicalNumberOfRows();i++){

            sheet1.getRow(i).createCell(2).setCellValue(3500+i);
    }

        //6- KAYDET: KAYIT İŞLEMİ FileOutputStream ile yapılır.
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);



    }
}
