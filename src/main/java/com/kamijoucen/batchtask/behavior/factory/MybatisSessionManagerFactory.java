package com.kamijoucen.batchtask.behavior.factory;

import javax.sql.DataSource;

import com.kamijoucen.batchtask.behavior.service.MybatisSessionManager;
import com.kamijoucen.batchtask.config.BatchTaskConfiguration;

public interface MybatisSessionManagerFactory {
    
    MybatisSessionManager createMybatisSessionManager(DataSource dataSource, BatchTaskConfiguration configuration);
    
}
