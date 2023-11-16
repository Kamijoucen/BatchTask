package com.kamijoucen.batchtask.test;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kamijoucen.batchtask.config.impl.BatchTaskConfigurationImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class BaseTest {

    private DataSource dataSource;

    private Properties properties;

    // 初始化 conf.properties
    public void initProperties() throws IOException {
        this.properties = new Properties();
        properties.load(BaseTest.class.getResourceAsStream("/dev.properties"));
        // properties.load(BaseTest.class.getResourceAsStream("/conf.properties"));
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
        BatchTaskConfigurationImpl configuration = new BatchTaskConfigurationImpl(dataSource);
        System.out.println(configuration.getUuid());
    }

    @BeforeEach
    void setUp() throws IOException {
        initProperties();
        initDataSource();
        initConfiguration();
    }

    @Test
    public void test() {
        System.out.println("hello world");
    }

}
