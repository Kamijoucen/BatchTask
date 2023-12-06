package com.kamijoucen.batchtask.behavior.factory.impl;

import javax.sql.DataSource;

import com.kamijoucen.batchtask.behavior.factory.MybatisSessionManagerFactory;
import com.kamijoucen.batchtask.behavior.service.MybatisSessionManager;
import com.kamijoucen.batchtask.behavior.service.impl.MybatisSessionManagerImpl;
import com.kamijoucen.batchtask.config.BatchTaskConfiguration;

public class MybatisSessionManagerFactoryImpl implements MybatisSessionManagerFactory {

    @Override
    public MybatisSessionManager createMybatisSessionManager(DataSource dataSource,
            BatchTaskConfiguration configuration) {
        return new MybatisSessionManagerImpl(dataSource, configuration);
    }

}
