package com.kamijoucen.batchtask.config;

import javax.sql.DataSource;

import com.kamijoucen.batchtask.api.TaskManager;
import com.kamijoucen.batchtask.behavior.IdGenerator;
import com.kamijoucen.batchtask.behavior.mybatis.MybatisSesstionManager;
import com.kamijoucen.powerstruct.api.ExecutionService;

public interface BatchTaskConfiguration {

    String getUuid();

    ExecutionService getExecutionService();

    IdGenerator getEntityIdGenerator();

    DataSource getDataSource();

    TaskManager getTaskManager();

    MybatisSesstionManager getMybatisSesstionManager();
    
}
