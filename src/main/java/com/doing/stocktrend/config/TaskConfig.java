package com.doing.stocktrend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @描述: 多线程执行定时任务
 * @日期 2019年5月28日
 */
@Configuration
public class TaskConfig {
    /**
     * @描述: 所有的定时任务都放在一个线程池中,定时任务启动时使用不同的线程
     * @return
     * @日期 2019年5月28日
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        // 设置scheduler执行线程为3个
        scheduler.setPoolSize(3);
        return scheduler;
    }
}