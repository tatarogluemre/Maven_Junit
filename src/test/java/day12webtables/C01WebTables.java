package day12webtables;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01WebTables extends TestBase {

//        https://the-internet.herokuapp.com/tables
//        Task 1 : Table1’i print edin
//        Task 2 : 3. Row’ datalarını print edin
//        Task 3 : Son row daki dataları print edin
//        Task 4 : 5. Column datalarini print edin
//        Task 5 : Iki parametreli bir Java metot oluşturalım: printData
//        Parameter 1 = row numarasi
//        Parameter 2 = column numarasi
//        printData(2,3);  => 2nd row, 3rd column daki datayı print etsin


    @Before
    public void beforeClass() throws Exception {
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    //Task 1 : Table1’i print edin
    @Test
    public void task01() {

        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("TABLE1 VERİLERİ");
        System.out.println(table1);
        System.out.println("2.Yol");
        List<WebElement> tableData = driver.findElements(By.xpath("//table[@id='table1']//td"));
        tableData.forEach(t-> System.out.println(t.getText()));

    }
    //        Task 2 : 3. Row’ datalarını print edin
    @Test
    public void task02() {
        //driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]"));
        System.out.println("3.RowDataları");
        rows.forEach(t-> System.out.print(t.getText()));

    }
    //        Task 3 : Son row daki dataları print edin
    @Test
    public void task03() {
        //driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sonSatirElemanlar= driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        sonSatirElemanlar.forEach(t-> System.out.print(t.getText()));
    }
    //        Task 4 : 5. Column datalarini print edin
    @Test
    public void task04(){
       // driver.get("https://the-internet.herokuapp.com/tables");
       List<WebElement>sonSutun= driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
       sonSutun.forEach(t-> System.out.println(t.getText()));
        System.out.println(driver.findElement(By.xpath("//table[@id='table1']//tr[" + 2 + "]//td[" + 3 + "]")).getText());


    }

    public void rowColumnMethod(int row, int column){

       WebElement rowColumn =  driver.findElement(By.xpath("//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]"));

        System.out.println(rowColumn.getText());
    }


    @Test
    public void task05() {

        rowColumnMethod(2,3);
    }
}
