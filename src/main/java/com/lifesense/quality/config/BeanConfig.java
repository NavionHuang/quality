package com.lifesense.quality.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 赵春定 on 2017/8/24.
 */
@Configuration
public class BeanConfig {

    @Bean
    SnowflakeIdWorker getSnowflakeIdWorker() {
        return new SnowflakeIdWorker(1L, 1L);
    }
}
