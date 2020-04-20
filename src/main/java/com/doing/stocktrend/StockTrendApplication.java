package com.doing.stocktrend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync//开启异步处理支持，开启springboot线程池
@EnableScheduling //支持定时任务
@SpringBootApplication
@MapperScan(basePackages = { "com.doing.stocktrend.mapper" })
public class StockTrendApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockTrendApplication.class, args);
    }

}
