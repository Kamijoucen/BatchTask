package com.kamijoucen.batchtask.config;

public abstract class BaseBehavior {

    protected final BatchTaskConfiguration configuration;

    public BaseBehavior(BatchTaskConfiguration configuration) {
        this.configuration = configuration;
    }
    
}
