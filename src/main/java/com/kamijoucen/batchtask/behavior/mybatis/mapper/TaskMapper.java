package com.kamijoucen.batchtask.behavior.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kamijoucen.batchtask.behavior.mybatis.entity.TaskEntity;

@Mapper
public interface TaskMapper {

    int insertTask(TaskEntity task);

    int batchInsertTask(@Param("tasks") List<TaskEntity> tasks);
    
    List<TaskEntity> getUnLockOrExpireTask(@Param("task") TaskEntity task, @Param("limit") int limit);
    
}
