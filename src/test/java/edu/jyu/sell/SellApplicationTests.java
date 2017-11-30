package edu.jyu.sell;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//为了让测试在Spring容器环境下执行
@RunWith(SpringRunner.class)
//spring-boot的启动类
@SpringBootTest
//如果不想每次都写private  final Logger logger = LoggerFactory.getLogger(XXX.class); 可以用注解@Slf4j
@Slf4j
public class SellApplicationTests {

    //private Logger logger = org.slf4j.LoggerFactory.getLogger(SellApplicationTests.class);
    @Test
    public void test1() {
//		logger.debug("debug..");
//		logger.info("info..");
//		logger.error("error..");
        log.debug("debug....");
		log.info("info.....");
		log.warn("warn...");
		log.error("error.....");

		//占位符形式输出日志
		log.info("info name:{}","Jason");
    }


}
