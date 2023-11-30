package com.kamijoucen.batchtask.test;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kamijoucen.batchtask.behavior.mybatis.MybatisSesstionManager;
import com.kamijoucen.batchtask.behavior.mybatis.entity.TaskEntity;
import com.kamijoucen.batchtask.behavior.mybatis.mapper.TaskMapper;
import com.kamijoucen.batchtask.config.impl.BatchTaskConfigurationImpl;
import com.kamijoucen.batchtask.executor.BatchSaveTaskExe;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class BaseTest {

    private DataSource dataSource;

    private Properties properties;

    private BatchTaskConfigurationImpl configuration;

    // 初始化 conf.properties
    public void initProperties() throws IOException {
        this.properties = new Properties();
        // BaseTest.class.getResourceAsStream("/conf.properties")
        try (InputStream input = BaseTest.class.getResourceAsStream("/dev.properties")) {
            properties.load(input);
        }
    }

    // 初始化hikari数据源
    public void initDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(properties.getProperty("jdbc.url"));
        config.setUsername(properties.getProperty("jdbc.username"));
        config.setPassword(properties.getProperty("jdbc.password"));
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(600000);
        config.setMaxLifetime(1800000);
        config.setConnectionTestQuery("SELECT 1");
        config.setPoolName("hikari");
        this.dataSource = new HikariDataSource(config);
    }

    // 初始化Configuration
    public void initConfiguration() {
        configuration = new BatchTaskConfigurationImpl(dataSource);
    }

    @BeforeEach
    void setUp() throws IOException {
        initProperties();
        initDataSource();
        initConfiguration();
    }

    @Test
    public void testInsert() {
        MybatisSesstionManager mybatisSesstionManager = configuration.getMybatisSesstionManager();

        try (SqlSession session = mybatisSesstionManager.openSession()) {
            TaskMapper mapper = session.getMapper(TaskMapper.class);

            TaskEntity task = new TaskEntity();
            task.setName("test");
            task.setVersion(1);
            task.setOwner(configuration.getUuid());
            task.setStatus("1");
            task.setCreateTime(LocalDateTime.now());
            task.setExpireTime(LocalDateTime.now());
            int result = mapper.insertTask(task);
            System.out.println(result);
            session.rollback();
        }
    }

    // test query
    @Test
    public void testQuery() {
        MybatisSesstionManager mybatisSesstionManager = configuration.getMybatisSesstionManager();

        try (SqlSession session = mybatisSesstionManager.openSession()) {
            TaskMapper mapper = session.getMapper(TaskMapper.class);

            TaskEntity task = new TaskEntity();
            task.setExpireTime(LocalDateTime.now());

            List<TaskEntity> taskList = mapper.getExpireTask(task, 10);
            System.out.println(taskList);

            session.commit();
        }
    }

    // batch insert
    @Test
    public void testBatchInsert() {

        List<TaskEntity> taskList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            TaskEntity task = new TaskEntity();
            task.setName("test");
            task.setVersion(1);
            task.setOwner(configuration.getUuid());
            task.setStatus("1");
            task.setCreateTime(LocalDateTime.now());
            task.setExpireTime(LocalDateTime.now());
            taskList.add(task);
        }
        BatchSaveTaskExe exe = new BatchSaveTaskExe(taskList);
        List<TaskEntity> execute = configuration.getExecutionService().execute(exe);
        System.out.println(execute.size());
    }

}
