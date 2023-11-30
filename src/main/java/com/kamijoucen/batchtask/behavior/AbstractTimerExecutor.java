package com.kamijoucen.batchtask.behavior;

import java.util.concurrent.TimeUnit;

import com.kamijoucen.batchtask.config.BatchTaskConfiguration;
import com.kamijoucen.powerstruct.exe.Exe;

public abstract class AbstractTimerExecutor implements TimerExecutor {

    protected final BatchTaskConfiguration configuration;

    protected final Exe<Void> runnable;

    protected final long initialDelay;

    protected final long period;

    protected final TimeUnit timeUnit;

    public AbstractTimerExecutor(BatchTaskConfiguration configuration, long initialDelay, long period,
            TimeUnit timeUnit, Exe<Void> runnable) {
        this.configuration = configuration;
        this.initialDelay = initialDelay;
        this.period = period;
        this.timeUnit = timeUnit;
        this.runnable = runnable;
    }

}
