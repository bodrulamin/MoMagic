package com.bodrul.momagic;

import com.bodrul.momagic.service.MoMagicServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import sun.misc.Signal;

@SpringBootApplication
@EnableScheduling
public class MoMagicApplication {
    static Logger logger = LoggerFactory.getLogger("Momagic");

    public static void main(String[] args) {
        SpringApplication.run(MoMagicApplication.class, args);
        Signal.handle(new Signal("INT"),  // SIGINT
                signal -> {
                    logger.info("");
                    logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++");
                    logger.info("Total Success : " + MoMagicServiceImpl.success);
                    logger.info("Total Failed : " + MoMagicServiceImpl.failed);
                    logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++");
                    logger.info("");

                    System.exit(1);
                });
    }

}
