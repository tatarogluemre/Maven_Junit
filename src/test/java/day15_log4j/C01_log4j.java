package day15_log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;



public class C01_log4j {

//3. Logger object olustur:
//    private static Logger logger = LogManager.getLogger(Demo1.class.getName());
//4. Logger fonksiyonuyla istenilen fonksiyonu kullan
//                 logger.debug("Debug logger");
//        logger.info("Info logger");
//        logger.error("Error logger");
//        logger.fatal("Fatal logger");

    private static Logger logger = LogManager.getLogger(C01_log4j.class.getName());
    @Test
    public void log4j() {
//logger objesi ile yazdırma işlemi yapma
        logger.fatal("Fatal Log!"); System.out.println("Emre Log");
        logger.error("Error Log!");
        logger.warn("Warn Log!");
        logger.debug("Debug Log!");
        logger.info("Info Log!");





    }
}



