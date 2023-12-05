package com.kamijoucen.batchtask.behavior.factory.impl;

import java.util.concurrent.TimeUnit;

import com.kamijoucen.batchtask.behavior.factory.TimerFactory;
import com.kamijoucen.batchtask.behavior.service.TimerExecutor;
import com.kamijoucen.batchtask.behavior.service.impl.DefaultTimerExecutorImpl;
import com.kamijoucen.batchtask.config.BatchTaskConfiguration;
import com.kamijoucen.powerstruct.exe.Exe;

public class TimerFactoryImpl implements TimerFactory {

    @Override
    public TimerExecutor createTimerExecutor(BatchTaskConfiguration configuration, long initialDelay, long period,
            TimeUnit timeUnit, Exe<Void> runnable) {
        return new DefaultTimerExecutorImpl(configuration, initialDelay, period, timeUnit, runnable);
    }

}
