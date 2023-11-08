package com.kamijoucen.batchtask.config.impl;

import javax.sql.DataSource;

import com.kamijoucen.batchtask.behavior.IdGenerator;
import com.kamijoucen.batchtask.behavior.impl.DBIncrementIdGeneratorImpl;
import com.kamijoucen.batchtask.behavior.impl.UUIdGeneratorImpl;
import com.kamijoucen.batchtask.config.BatchTaskConfiguration;
import com.kamijoucen.batchtask.context.ContextInterceptor;
import com.kamijoucen.powerstruct.api.ExecutionService;
import com.kamijoucen.powerstruct.api.impl.ExecutionServiceImpl;
import com.kamijoucen.powerstruct.config.StructConfiguration;
import com.kamijoucen.powerstruct.config.StructConfigurationImpl;

public class BatchTaskConfigurationImpl implements BatchTaskConfiguration {

    private final String uuid;

    private DataSource dataSource;
    
    private StructConfiguration structConfiguration;

    private ExecutionService executionService;

    private IdGenerator entityIdGenerator;

    private IdGenerator uuIdGenerator;
    
    public BatchTaskConfigurationImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        init();
        initContext();
        this.uuid = uuIdGenerator.nextId().toString();
    }
     
    private void initContext() {
        this.structConfiguration.getExecutor().addExeInterceptor(new ContextInterceptor(this));
    }

    private void init() {
        this.structConfiguration = new StructConfigurationImpl();
        this.executionService = new ExecutionServiceImpl(this.structConfiguration);
        this.entityIdGenerator = new DBIncrementIdGeneratorImpl(this);
        this.uuIdGenerator = new UUIdGeneratorImpl(this);
    }
    
    @Override
    public String getUuid() {
        return this.uuid;
    }

    @Override
    public ExecutionService getExecutionService() {
        return this.executionService;
    }

    @Override
    public IdGenerator getEntityIdGenerator() {
        return this.entityIdGenerator;
    }

    // get and set dataSource
    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // set entity id generator
    public void setEntityIdGenerator(IdGenerator entityIdGenerator) {
        this.entityIdGenerator = entityIdGenerator;
    }

    // get uuid generator
    public IdGenerator getUuIdGenerator() {
        return uuIdGenerator;
    }
    
    // set uuid generator
    public void setUuIdGenerator(IdGenerator uuIdGenerator) {
        this.uuIdGenerator = uuIdGenerator;
    }

}
