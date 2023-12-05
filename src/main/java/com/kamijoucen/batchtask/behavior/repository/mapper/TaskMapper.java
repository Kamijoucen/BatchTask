package com.kamijoucen.batchtask.behavior.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kamijoucen.batchtask.behavior.repository.entity.TaskEntity;

@Mapper
public interface TaskMapper {

    int insertTask(TaskEntity task);

    int batchInsertTask(@Param("tasks") List<TaskEntity> tasks);
    
    List<TaskEntity> getUnLockTask(@Param("task") TaskEntity task, @Param("limit") int limit);

    List<TaskEntity> getExpireTask(@Param("task") TaskEntity task, @Param("limit") int limit);
    
}
