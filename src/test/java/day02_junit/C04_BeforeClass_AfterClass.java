package day02_junit;

import org.junit.*;

public class C04_BeforeClass_AfterClass {

    /*Before Class ve After Class notasyonları sadece static methodlar için çalışır
      Before Class ve After Class kullanırsak oluşturduğumuz @Test methodlarının hepsini aynı anda çalıştırıp
      enson @AfterClass'ı çalıştırırız.
        Ama sadece @Before ve @After kullanırsak her test için @Before ve @After kullanır.
     */


    @BeforeClass
    public static void setUp(){

        System.out.println("Bütün testlerden önce çalıştı");

    }
    @AfterClass

    public static void tearDown(){

        System.out.println("Bütün Testlerden sonra çalıştı");

    }

    @Before
    public void setUpBefore(){

        System.out.println("her test methodundan önce çalıştı");
    }
    @After
    public void tearDownAfter(){

        System.out.println("Her test methodundan sonra çalıştı");
    }

    @Test
    public void ilk(){
        System.out.println("İlk Test");
    }

    @Test
    public void ikinci(){
        System.out.println("İkinci Test");
    }

    @Test
    @Ignore
    public void test03(){

        System.out.println("Üçüncü Test");
    }

}
