package com.site.blog.my.core.util;

import com.site.blog.my.core.entity.ScheduleTask;
import com.site.blog.my.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/***
 * 定时任务类
 */
@Component
@EnableAsync
@EnableScheduling
public class ScheduleTaskUtil {

    @Autowired
    RedisTemplate redisTemplate;
    @Resource
    private BlogService blogService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private LinkService linkService;
    @Resource
    private TagService tagService;
    @Resource
    private CommentService commentService;
    @Resource
    private ScheduleTaskService scheduleTaskService;

    @Async
    @Scheduled(fixedDelay = 1000)
    public void toRedis() throws InterruptedException {
        redisTemplate.opsForValue().set("categoryCount",categoryService.getTotalCategories(),60*10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("blogCount", blogService.getTotalBlogs(),60 * 10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("linkCount", linkService.getTotalLinks(),60 * 10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("tagCount", tagService.getTotalTags(),60 * 10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("commentCount", commentService.getTotalComments(),60 * 10, TimeUnit.SECONDS);
        ScheduleTask scheduleTask = new ScheduleTask();
        scheduleTask.setCreateTime(new Date());
        scheduleTask.setIs_Success(1);
        scheduleTask.setTaskName("向redis数据");
//        scheduleTaskService.ScheduleTaskInsert(scheduleTask);
    }

    @Async
    @Scheduled(fixedDelay = 5000)
    public void toDB(){
        System.out.println("7777"+ LocalDate.now());
    }
}
