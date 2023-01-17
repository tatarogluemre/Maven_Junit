package deneme;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void test01() throws IOException {

        String path = "./src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet1 = workbook.getSheet("Sheet1");
        Row row1 = sheet1.getRow(3);
        Cell cell1 = row1.getCell(1);
        System.out.println(cell1);



    }
}
