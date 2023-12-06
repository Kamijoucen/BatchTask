package com.kamijoucen.batchtask.behavior.service;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public interface MybatisSessionManager {

    SqlSession openSession();

    SqlSession openSession(ExecutorType executorType);
    
    SqlSessionFactory getSqlSessionFactory();
    
}
