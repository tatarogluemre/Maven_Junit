package day02_junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
    public void setUp(){
        System.out.println("her test methodundan önce çalışır");
    }
    @After
    public void tearDown(){

        System.out.println("Her test methodundan sonra çalışır");
    }
    @Test
    public void test01(){
        System.out.println("ilkTest");
    }
    @Test
    public void test02(){
        System.out.println("ikinciTest");
    }
}
