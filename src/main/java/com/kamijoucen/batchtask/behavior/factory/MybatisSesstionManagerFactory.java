package com.kamijoucen.batchtask.behavior.factory;

import javax.sql.DataSource;

import com.kamijoucen.batchtask.behavior.service.MybatisSesstionManager;
import com.kamijoucen.batchtask.config.BatchTaskConfiguration;

public interface MybatisSesstionManagerFactory {
    
    MybatisSesstionManager createMybatisSesstionManager(DataSource dataSource, BatchTaskConfiguration configuration);
    
}
