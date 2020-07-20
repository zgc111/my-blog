package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.dao.ScheduleTaskMapper;
import com.site.blog.my.core.entity.ScheduleTask;
import com.site.blog.my.core.service.ScheduleTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScheduleTaskServiceImpl implements ScheduleTaskService {
    @Autowired
    ScheduleTaskMapper scheduleTaskMapper;

    @Override
    @Transactional
    public int ScheduleTaskInsert(ScheduleTask scheduleTask) {
        int i = scheduleTaskMapper.ScheduleTaskInsert(scheduleTask);
        return i;
    }

    @Override
    public List<ScheduleTask> getOutList() {
        List<ScheduleTask> scheduleTaskMapperOutList = scheduleTaskMapper.getOutList();
        if(scheduleTaskMapperOutList.size()==0){
            return null;
        }
        return scheduleTaskMapperOutList;
    }

    @Override
    public int deleteById(Integer id) {
        int i = scheduleTaskMapper.deleteById(id);
        return i;
    }
}
