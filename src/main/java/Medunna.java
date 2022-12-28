import java.sql.*;

public class Medunna {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db", "medunna_user", "medunna_pass_987");
        Statement statement = connection.createStatement();
        boolean createTable = statement.execute("CREATE TABLE ogrenciler (id int ,name varchar(25),job varchar(20))");
        if (createTable) {
            System.out.println("Tablo oluşturulmadı");
        }
        System.out.println("Tablo oluşturuldu");

        boolean i1 = statement.execute("INSERT INTO ogrenciler VALUES(12,'ALİ','STD')");
        boolean i2 = statement.execute("INSERT INTO ogrenciler VALUES(13,'VEİ','ASD')");
        boolean i3 = statement.execute("INSERT INTO ogrenciler VALUES(14,'DELİ','EDS')");

        if(i1&&i2&&i3){
            System.out.println("Tabloya veriler eklenmedi");
        }else System.out.println("Tabloya veriler eklendi");

        ResultSet rst = statement.executeQuery("Select * From ogrenciler");

        while (rst.next()){

            System.out.println(rst.getInt(1)+"----"+rst.getString(2)+"----"+rst.getString(3));
        }

        boolean delete = statement.execute("DROP TABLE ogrenciler");
        if(delete){
            System.out.println("tablo silinmedi");
        }else System.out.println("Tablo silindi");


    }


}
