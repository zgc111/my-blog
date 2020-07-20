package com.site.blog.my.core.util;

import cn.hutool.core.date.DateUtil;
import com.site.blog.my.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * redis初始化数据
 */
@Component
@Order(value = 1)
public class InitUtil implements ApplicationRunner {

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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String startDate = DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        System.out.println("查询数据开始,开始写入数据!开始时间:"+startDate);
        redisTemplate.opsForValue().set("categoryCount",categoryService.getTotalCategories());
        redisTemplate.opsForValue().set("blogCount", blogService.getTotalBlogs());
        redisTemplate.opsForValue().set("linkCount", linkService.getTotalLinks());
        redisTemplate.opsForValue().set("tagCount", tagService.getTotalTags());
        redisTemplate.opsForValue().set("commentCount", commentService.getTotalComments());

        redisTemplate.opsForValue().set("blogList",blogService.selectList());
        redisTemplate.opsForValue().set("categoryList",categoryService.getAllCategories());
        redisTemplate.opsForValue().set("linkList",linkService.getAllList());
        redisTemplate.opsForValue().set("commentList",commentService.getAllList());
        redisTemplate.opsForValue().set("tagList",tagService.getAllList());
        String endDate = DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        System.out.println("写入数据完成!结束时间:"+endDate);
    }
}
