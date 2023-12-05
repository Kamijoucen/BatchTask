package com.kamijoucen.batchtask.config.impl;

import java.util.Objects;

import javax.sql.DataSource;

import com.kamijoucen.batchtask.api.TaskManager;
import com.kamijoucen.batchtask.api.impl.TaskManagerImpl;
import com.kamijoucen.batchtask.behavior.service.IdGenerator;
import com.kamijoucen.batchtask.behavior.service.MybatisSesstionManager;
import com.kamijoucen.batchtask.behavior.service.impl.MybatisSesstionManagerImpl;
import com.kamijoucen.batchtask.behavior.service.impl.UUIdGeneratorImpl;
import com.kamijoucen.batchtask.config.BatchTaskConfiguration;
import com.kamijoucen.batchtask.config.BatchTaskRuntimeContextFactory;
import com.kamijoucen.batchtask.config.ContextInterceptor;
import com.kamijoucen.powerstruct.api.ExecutionService;
import com.kamijoucen.powerstruct.api.impl.ExecutionServiceImpl;
import com.kamijoucen.powerstruct.config.StructConfiguration;
import com.kamijoucen.powerstruct.config.StructConfigurationImpl;

public class BatchTaskConfigurationImpl implements BatchTaskConfiguration {

    private final String uuid;

    private DataSource dataSource;

    private StructConfiguration structConfiguration;

    private ExecutionService executionService;

    private IdGenerator uuIdGenerator;

    private TaskManager taskManager;

    private MybatisSesstionManager mybatisSesstionManager;

    public BatchTaskConfigurationImpl(DataSource dataSource) {
        Objects.requireNonNull(dataSource);
        this.dataSource = dataSource;
        initBehavior();
        initStructConfiguration();
        this.uuid = uuIdGenerator.nextId().toString();
    }

    private void initStructConfiguration() {
        StructConfigurationImpl structConfigurationImpl = new StructConfigurationImpl();
        structConfigurationImpl = new StructConfigurationImpl();
        structConfigurationImpl.getExecutor().addExeInterceptor(new ContextInterceptor(this));
        structConfigurationImpl
                .setRuntimeContextFactory(new BatchTaskRuntimeContextFactory(this, structConfigurationImpl));
        this.structConfiguration = structConfigurationImpl;
        this.executionService = new ExecutionServiceImpl(this.structConfiguration);
    }

    private void initBehavior() {
        this.uuIdGenerator = new UUIdGeneratorImpl(this);
        this.taskManager = new TaskManagerImpl(this);

        // init mybatis
        this.mybatisSesstionManager = new MybatisSesstionManagerImpl(this.dataSource, this);
        this.mybatisSesstionManager.init();
    }

    @Override
    public String getUuid() {
        return this.uuid;
    }

    @Override
    public ExecutionService getExecutionService() {
        return this.executionService;
    }

    // get and set dataSource
    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public TaskManager getTaskManager() {
        return taskManager;
    }

    public void setTaskManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // get uuid generator
    public IdGenerator getUuIdGenerator() {
        return uuIdGenerator;
    }

    // set uuid generator
    public void setUuIdGenerator(IdGenerator uuIdGenerator) {
        this.uuIdGenerator = uuIdGenerator;
    }

    @Override
    public MybatisSesstionManager getMybatisSesstionManager() {
        return this.mybatisSesstionManager;
    }

}
