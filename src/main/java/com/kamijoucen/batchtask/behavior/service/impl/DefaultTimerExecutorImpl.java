package com.kamijoucen.batchtask.behavior.service.impl;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.kamijoucen.batchtask.config.BatchTaskConfiguration;
import com.kamijoucen.powerstruct.exe.Exe;

public class DefaultTimerExecutorImpl extends AbstractTimerExecutor {

    private final Timer timer = new Timer();

    private boolean isStart = false;

    public DefaultTimerExecutorImpl(BatchTaskConfiguration configuration, long initialDelay, long period,
            TimeUnit timeUnit, Exe<Void> runnable) {
        super(configuration, initialDelay, period, timeUnit, runnable);
        checkArgs();
    }

    private void checkArgs() {
        if (initialDelay < 0) {
            throw new IllegalArgumentException("initialDelay must be >= 0");
        }
        if (period <= 0) {
            throw new IllegalArgumentException("period must be > 0");
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("timeUnit must be not null");
        }
        if (runnable == null) {
            throw new IllegalArgumentException("runnable must be not null");
        }
    }

    @Override
    public synchronized void start() {
        if (isStart) {
            return;
        }
        isStart = true;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                DefaultTimerExecutorImpl.this.configuration.getExecutionService().execute(runnable);
            }
        }, timeUnit.toMillis(initialDelay), timeUnit.toMillis(period));
    }

    @Override
    public synchronized void stop() {
        if (!isStart) {
            return;
        }
        timer.cancel();
        isStart = false;
    }

}
