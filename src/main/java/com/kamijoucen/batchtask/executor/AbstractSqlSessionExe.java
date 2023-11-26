package com.kamijoucen.batchtask.executor;

import com.kamijoucen.batchtask.behavior.mybatis.MybatisSesstionManager;
import com.kamijoucen.batchtask.domain.ContextPropertyEnum;
import com.kamijoucen.powerstruct.context.RuntimeContext;
import com.kamijoucen.powerstruct.exe.AbstractExe;

public abstract class AbstractSqlSessionExe<T> extends AbstractExe<T> {

    @Override
    public T execute(RuntimeContext ctx) {
        Object property = ctx.getProperty(ContextPropertyEnum.SQL_SESSION_FACTORY.name);
        if (!(property instanceof MybatisSesstionManager)) {
            throw new RuntimeException("sql session factory is not instance of MybatisSesstionManager");
        }
        return this.execute(ctx, ((MybatisSesstionManager) property));
    }

    abstract public T execute(RuntimeContext ctx, MybatisSesstionManager session);

}
