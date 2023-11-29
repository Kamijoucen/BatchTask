package com.kamijoucen.batchtask.executor;

import com.kamijoucen.batchtask.behavior.mybatis.MybatisSesstionManager;
import com.kamijoucen.batchtask.config.BatchTaskConfiguration;
import com.kamijoucen.batchtask.domain.ContextPropertyEnum;
import com.kamijoucen.powerstruct.context.RuntimeContext;

public abstract class AbstractSessionManagerExe<T> extends AbstractBatchTaskExe<T> {

    @Override
    public T execute(RuntimeContext ctx, BatchTaskConfiguration configuration) {
        Object property = ctx.getProperty(ContextPropertyEnum.SQL_SESSION_MANAGER);
        if (!(property instanceof MybatisSesstionManager)) {
            throw new RuntimeException("sql session factory is not instance of MybatisSesstionManager");
        }
        return this.execute(ctx, ((MybatisSesstionManager) property));
    }

    abstract public T execute(RuntimeContext ctx, MybatisSesstionManager manager);

}
