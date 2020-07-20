package com.site.blog.my.core.util;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/***
 * 定时任务类
 */
@Component
@EnableAsync
@EnableScheduling
public class ScheduleTaskUtil {

    @Async
    @Scheduled(fixedDelay = 5000)
    public void yoRedis(){

    }
}
