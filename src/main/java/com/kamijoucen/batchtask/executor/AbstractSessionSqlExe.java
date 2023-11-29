package com.kamijoucen.batchtask.executor;

import org.apache.ibatis.session.SqlSession;

import com.kamijoucen.batchtask.behavior.mybatis.MybatisSesstionManager;
import com.kamijoucen.powerstruct.context.RuntimeContext;

public abstract class AbstractSessionSqlExe<T> extends AbstractSessionManagerExe<T> {

    protected MybatisSesstionManager manager;
    
    @Override
    public T execute(RuntimeContext ctx, MybatisSesstionManager manager) {
        this.manager = manager;
        SqlSession session = manager.openSession();
        try {
            T result = execute(ctx, session);
            session.commit();
            return result;
        } catch(Throwable e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }        
    }

    abstract public T execute(RuntimeContext ctx, SqlSession session);
    
}
