package com.kamijoucen.batchtask.behavior;

import java.util.concurrent.TimeUnit;

import com.kamijoucen.powerstruct.exe.Exe;

public abstract class AbstractTimerExecutor implements TimerExecutor {

    private final Exe<Void> runnable;

    private final long initialDelay;

    private final long period;

    private final TimeUnit timeUnit;

    public AbstractTimerExecutor(long initialDelay, long period, TimeUnit timeUnit, Exe<Void> runnable) {
        this.initialDelay = initialDelay;
        this.period = period;
        this.timeUnit = timeUnit;
        this.runnable = runnable;
    }

}
