package com.kamijoucen.batchtask.behavior.factory.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.kamijoucen.batchtask.behavior.factory.ThreadPoolFactory;

public class ThreadPoolFactoryImpl implements ThreadPoolFactory {

    @Override
    public ExecutorService createThreadPool(int poolSize) {
        return Executors.newFixedThreadPool(poolSize);
    }
    
}
