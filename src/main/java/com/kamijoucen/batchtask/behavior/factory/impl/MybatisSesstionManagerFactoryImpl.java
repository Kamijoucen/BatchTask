package com.kamijoucen.batchtask.behavior.factory.impl;

import javax.sql.DataSource;

import com.kamijoucen.batchtask.behavior.factory.MybatisSesstionManagerFactory;
import com.kamijoucen.batchtask.behavior.service.MybatisSesstionManager;
import com.kamijoucen.batchtask.behavior.service.impl.MybatisSesstionManagerImpl;
import com.kamijoucen.batchtask.config.BatchTaskConfiguration;

public class MybatisSesstionManagerFactoryImpl implements MybatisSesstionManagerFactory {

    @Override
    public MybatisSesstionManager createMybatisSesstionManager(DataSource dataSource,
            BatchTaskConfiguration configuration) {
        return new MybatisSesstionManagerImpl(dataSource, configuration);
    }

}
