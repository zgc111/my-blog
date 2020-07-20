package com.site.blog.my.core.util;

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

    @Async
    @Scheduled(fixedDelay = 1000)
    public void toRedis() throws InterruptedException {
        redisTemplate.opsForValue().set("categoryCount",categoryService.getTotalCategories(),60*10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("blogCount", blogService.getTotalBlogs(),60 * 10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("linkCount", linkService.getTotalLinks(),60 * 10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("tagCount", tagService.getTotalTags(),60 * 10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("commentCount", commentService.getTotalComments(),60 * 10, TimeUnit.SECONDS);

        redisTemplate.opsForValue().set("blogList",blogService.selectList(),60 * 10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("categoryList",categoryService.getAllCategories(),60 * 10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("linkList",linkService.getAllList(),60 * 10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("commentList",commentService.getAllList(),60 * 10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("tagList",tagService.getAllList(),60 * 10, TimeUnit.SECONDS);
    }

    @Async
    @Scheduled(fixedDelay = 5000)
    public void toDB(){
        System.out.println("7777"+ LocalDate.now());
    }
}
