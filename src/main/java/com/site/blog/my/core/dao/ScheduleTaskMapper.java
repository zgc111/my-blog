package com.site.blog.my.core.dao;

import com.site.blog.my.core.entity.ScheduleTask;

import java.util.List;

public interface ScheduleTaskMapper {
     int ScheduleTaskInsert(ScheduleTask scheduleTask);
     List<ScheduleTask> getOutList();
     int deleteById(Integer id);
}
