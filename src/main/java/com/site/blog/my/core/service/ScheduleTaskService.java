package com.site.blog.my.core.service;

import com.site.blog.my.core.entity.ScheduleTask;

import java.util.List;

public interface ScheduleTaskService {
    int ScheduleTaskInsert(ScheduleTask scheduleTask);
    List<ScheduleTask> getOutList();
    int deleteById(Integer id);
}
