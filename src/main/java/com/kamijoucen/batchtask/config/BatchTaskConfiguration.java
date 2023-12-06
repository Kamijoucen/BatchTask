package com.kamijoucen.batchtask.config;

import javax.sql.DataSource;

import com.kamijoucen.batchtask.api.TaskManager;
import com.kamijoucen.batchtask.behavior.service.MybatisSessionManager;
import com.kamijoucen.powerstruct.api.ExecutionService;

public interface BatchTaskConfiguration {

    String getUuid();

    DataSource getDataSource();

    ExecutionService getExecutionService();

    MybatisSessionManager getMybatisSessionManager();
    
    TaskManager getTaskManager();
    
}
