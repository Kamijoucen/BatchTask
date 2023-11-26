package com.kamijoucen.batchtask.executor;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

import com.kamijoucen.batchtask.behavior.mybatis.MybatisSesstionManager;
import com.kamijoucen.batchtask.behavior.mybatis.entity.TaskEntity;
import com.kamijoucen.powerstruct.context.RuntimeContext;

public class BatchSaveTaskExe extends AbstractSqlSessionExe<Void> {

    private final List<TaskEntity> taskList;

    public BatchSaveTaskExe(List<TaskEntity> taskList) {
        this.taskList = taskList;
    }

    @Override
    public Void execute(RuntimeContext ctx, MybatisSesstionManager manager) {
        if (CollectionUtils.isEmpty(taskList)) {            
            return null;
        }
        return null;
    }
    
}