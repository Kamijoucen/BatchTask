package com.kamijoucen.batchtask.config;

import com.kamijoucen.batchtask.domain.ContextPropertyEnum;
import com.kamijoucen.powerstruct.config.StructConfiguration;
import com.kamijoucen.powerstruct.config.behavior.RuntimeContextFactory;
import com.kamijoucen.powerstruct.context.RuntimeContext;

public class BatchTaskRuntimeContextFactory extends RuntimeContextFactory {

    private final BatchTaskConfiguration batchTaskConfiguration;

    public BatchTaskRuntimeContextFactory(BatchTaskConfiguration batchTaskConfiguration,
            StructConfiguration configuration) {
        super(configuration);
        this.batchTaskConfiguration = batchTaskConfiguration;
    }

    @Override
    public RuntimeContext create() {
        RuntimeContext context = super.create();
        context.addProperty(ContextPropertyEnum.BATCH_TASK_CONFIGURATION, batchTaskConfiguration);
        context.addProperty(ContextPropertyEnum.SQL_SESSION_MANAGER,
                batchTaskConfiguration.getMybatisSessionManager());
        return context;
    }

}
