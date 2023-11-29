package com.kamijoucen.batchtask.executor;

import com.kamijoucen.batchtask.config.BatchTaskConfiguration;
import com.kamijoucen.batchtask.domain.ContextPropertyEnum;
import com.kamijoucen.powerstruct.context.RuntimeContext;
import com.kamijoucen.powerstruct.exe.AbstractExe;

public abstract class AbstractBatchTaskExe<T> extends AbstractExe<T> {
    
    protected BatchTaskConfiguration configuration;
    
    @Override
    public T execute(RuntimeContext ctx) {
        Object property = ctx.getProperty(ContextPropertyEnum.BATCH_TASK_CONFIGURATION);
        if (!(property instanceof BatchTaskConfiguration)) {
            throw new RuntimeException("batch task configuration is not instance of BatchTaskConfiguration");
        }
        this.configuration = (BatchTaskConfiguration) property;
        return execute(ctx, configuration);
    }

    abstract public T execute(RuntimeContext ctx, BatchTaskConfiguration configuration);
    
}
