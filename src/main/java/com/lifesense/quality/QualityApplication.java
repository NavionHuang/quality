package com.lifesense.quality;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableCaching
@MapperScan("com.lifesense.quality.dao")//扫描mybatis的mapper，使用统一注解方式，不在需要每个Mapper类上面添加注解@Mapper
public class QualityApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(QualityApplication.class, args);
    }
}
