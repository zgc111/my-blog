package com.site.blog.my.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 定时任务实体类
 */
public class ScheduleTask implements Serializable {

    private Integer id;
    private String TaskName;
    private String TaskTime;
    private Integer Is_Success;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public String getTaskTime() {
        return TaskTime;
    }

    public void setTaskTime(String taskTime) {
        TaskTime = taskTime;
    }

    public Integer getIs_Success() {
        return Is_Success;
    }

    public void setIs_Success(Integer is_Success) {
        Is_Success = is_Success;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "ScheduleTask{" +
                "id=" + id +
                ", TaskName='" + TaskName + '\'' +
                ", TaskTime='" + TaskTime + '\'' +
                ", Is_Success=" + Is_Success +
                ", createTime=" + createTime +
                '}';
    }
}
