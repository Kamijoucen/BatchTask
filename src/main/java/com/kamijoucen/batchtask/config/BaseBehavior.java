package com.kamijoucen.batchtask.config;

import java.util.Objects;

public abstract class BaseBehavior {

    protected final BatchTaskConfiguration configuration;

    public BaseBehavior(BatchTaskConfiguration configuration) {
        Objects.requireNonNull(configuration, "configuration can not be null");
        this.configuration = configuration;
    }
    
}
