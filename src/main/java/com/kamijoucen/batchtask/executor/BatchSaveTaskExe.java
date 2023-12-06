package com.kamijoucen.batchtask.executor;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kamijoucen.batchtask.behavior.repository.entity.TaskEntity;
import com.kamijoucen.batchtask.behavior.repository.mapper.TaskMapper;
import com.kamijoucen.batchtask.behavior.service.MybatisSessionManager;
import com.kamijoucen.powerstruct.context.RuntimeContext;

public class BatchSaveTaskExe extends AbstractSessionSqlExe<List<TaskEntity>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchSaveTaskExe.class);

    private final List<TaskEntity> taskList;
 
    public BatchSaveTaskExe(List<TaskEntity> taskList) {
        this.taskList = taskList;
    }

    @Override
    public List<TaskEntity> execute(RuntimeContext ctx, SqlSession session, MybatisSessionManager manager) {
        if (CollectionUtils.isEmpty(taskList)) {
            return Collections.emptyList();
        }
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        for (TaskEntity task : taskList) {
            mapper.insertTask(task);
        }
        return taskList;
    }

    @Override
    public ExecutorType getExecutionType() {
        return ExecutorType.BATCH;
    }

}