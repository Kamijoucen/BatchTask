package com.kamijoucen.batchtask.behavior.mybatis;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public interface MybatisSesstionManager {

    void init();
    
    SqlSession openSession();

    SqlSession openSession(ExecutorType executorType);
    
    SqlSessionFactory getSqlSessionFactory();
    
}
