package com.kamijoucen.batchtask.executor;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kamijoucen.batchtask.behavior.mybatis.entity.TaskEntity;
import com.kamijoucen.batchtask.behavior.mybatis.mapper.TaskMapper;
import com.kamijoucen.powerstruct.context.RuntimeContext;

public class BatchSaveTaskExe extends AbstractSessionSqlExe<List<TaskEntity>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchSaveTaskExe.class);
    
    private final List<TaskEntity> taskList;

    public BatchSaveTaskExe(List<TaskEntity> taskList) {
        this.taskList = taskList;
    }

    @Override
    public List<TaskEntity> execute(RuntimeContext ctx, SqlSession session) {
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        int batchInsertTask = mapper.batchInsertTask(taskList);
        if (batchInsertTask != taskList.size()) {
            LOGGER.error("batch insert task error, insert count: {}, task count: {}", batchInsertTask, taskList.size());
        }
        return taskList;
    }
    
}