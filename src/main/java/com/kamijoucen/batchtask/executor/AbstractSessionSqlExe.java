package com.kamijoucen.batchtask.executor;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.kamijoucen.batchtask.behavior.service.MybatisSessionManager;
import com.kamijoucen.powerstruct.context.RuntimeContext;

public abstract class AbstractSessionSqlExe<T> extends AbstractSessionManagerExe<T> {

    @Override
    public T execute(RuntimeContext ctx, MybatisSessionManager manager) {
        SqlSession session = manager.openSession(getExecutionType());
        try {
            T result = execute(ctx, session, manager);
            session.commit();
            return result;
        } catch (Throwable e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public ExecutorType getExecutionType() {
        return ExecutorType.SIMPLE;
    }
    
    abstract public T execute(RuntimeContext ctx, SqlSession session, MybatisSessionManager manager);
    
}
