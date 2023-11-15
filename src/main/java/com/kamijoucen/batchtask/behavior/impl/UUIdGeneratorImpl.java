package com.kamijoucen.batchtask.behavior.impl;

import java.util.UUID;

import com.kamijoucen.batchtask.behavior.IdGenerator;
import com.kamijoucen.batchtask.config.BaseBehavior;
import com.kamijoucen.batchtask.config.BatchTaskConfiguration;

public class UUIdGeneratorImpl extends BaseBehavior implements IdGenerator {

    public UUIdGeneratorImpl(BatchTaskConfiguration configuration) {
        super(configuration);
    }

    @Override
    public Object nextId() {
        return UUID.randomUUID().toString();
    }

}
