package com.kamijoucen.batchtask.behavior.impl;

import java.util.concurrent.TimeUnit;

import com.kamijoucen.batchtask.behavior.AbstractTimerExecutor;
import com.kamijoucen.powerstruct.exe.Exe;

public class DefaultTimerExecutorImpl extends AbstractTimerExecutor {

    
    

    public DefaultTimerExecutorImpl(long initialDelay, long period, TimeUnit timeUnit, Exe<Void> runnable) {
        super(initialDelay, period, timeUnit, runnable);
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stop'");
    }
    
}
