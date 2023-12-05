package com.kamijoucen.batchtask.behavior.service.impl;

import java.util.Objects;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.kamijoucen.batchtask.behavior.repository.mapper.BatchMapper;
import com.kamijoucen.batchtask.behavior.repository.mapper.TaskMapper;
import com.kamijoucen.batchtask.behavior.service.MybatisSesstionManager;
import com.kamijoucen.batchtask.config.BaseBehavior;
import com.kamijoucen.batchtask.config.BatchTaskConfiguration;

public class MybatisSesstionManagerImpl extends BaseBehavior implements MybatisSesstionManager {

    private final DataSource dataSource;

    private SqlSessionFactory sqlSessionFactory;
    
    public MybatisSesstionManagerImpl(DataSource dataSource, BatchTaskConfiguration configuration) {
        super(configuration);
        Objects.requireNonNull(dataSource, "dataSource is null");
        this.dataSource = dataSource;
    }
    
    @Override
    public synchronized void init() {
        if (sqlSessionFactory != null) {
            return;
        }
        Environment environment = new Environment("development", new JdbcTransactionFactory(), dataSource);
        
        Configuration configuration = new Configuration(environment);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.addMapper(TaskMapper.class);
        configuration.addMapper(BatchMapper.class);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    @Override
    public SqlSessionFactory getSqlSessionFactory() {
        Objects.requireNonNull(sqlSessionFactory, "sqlSessionFactory is not init");
        return sqlSessionFactory;
    }

    @Override
    public SqlSession openSession() {
        Objects.requireNonNull(sqlSessionFactory, "sqlSessionFactory is not init");        
        return sqlSessionFactory.openSession();
    }

    @Override
    public SqlSession openSession(ExecutorType executorType) {
        Objects.requireNonNull(sqlSessionFactory, "sqlSessionFactory is not init");
        return sqlSessionFactory.openSession(executorType);
    }
    
}
