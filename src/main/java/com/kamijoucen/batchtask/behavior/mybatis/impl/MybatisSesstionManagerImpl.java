package com.kamijoucen.batchtask.behavior.mybatis.impl;

import java.util.Objects;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.kamijoucen.batchtask.behavior.mybatis.MybatisSesstionManager;
import com.kamijoucen.batchtask.behavior.mybatis.mapper.TaskMapper;

public class MybatisSesstionManagerImpl implements MybatisSesstionManager {

    private final DataSource dataSource;

    private SqlSessionFactory sqlSessionFactory;
    
    public MybatisSesstionManagerImpl(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    private void initMapper(Configuration configuration) {
        configuration.addMapper(TaskMapper.class);
    }

    @Override
    public synchronized void init() {
        if (sqlSessionFactory != null) {
            return;
        }
        Environment environment = new Environment("development", new JdbcTransactionFactory(), dataSource);
        
        Configuration configuration = new Configuration(environment);
        configuration.setMapUnderscoreToCamelCase(true);
        
        initMapper(configuration);

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
