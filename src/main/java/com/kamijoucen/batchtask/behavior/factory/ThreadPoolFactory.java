package com.kamijoucen.batchtask.behavior.factory;

import java.util.concurrent.ExecutorService;

public interface ThreadPoolFactory {

    ExecutorService createThreadPool(int poolSize);
    
}
