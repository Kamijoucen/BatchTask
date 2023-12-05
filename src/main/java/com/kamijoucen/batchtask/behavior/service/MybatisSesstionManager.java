package com.kamijoucen.batchtask.behavior.service;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public interface MybatisSesstionManager {

    SqlSession openSession();

    SqlSession openSession(ExecutorType executorType);
    
    SqlSessionFactory getSqlSessionFactory();
    
}
