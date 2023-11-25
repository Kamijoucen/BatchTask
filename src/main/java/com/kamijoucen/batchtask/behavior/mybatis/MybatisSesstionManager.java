package com.kamijoucen.batchtask.behavior.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public interface MybatisSesstionManager {

    void init();
    
    SqlSession openSession();
    
    SqlSessionFactory getSqlSessionFactory();
    
}
