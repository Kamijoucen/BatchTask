package com.kamijoucen.batchtask.behavior.factory;

import java.util.concurrent.TimeUnit;

import com.kamijoucen.batchtask.behavior.service.TimerExecutor;
import com.kamijoucen.batchtask.config.BatchTaskConfiguration;
import com.kamijoucen.powerstruct.exe.Exe;

public interface TimerFactory {

    TimerExecutor createTimerExecutor(BatchTaskConfiguration configuration, long initialDelay, long period,
            TimeUnit timeUnit, Exe<Void> runnable);

}
