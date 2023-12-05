package com.kamijoucen.batchtask.behavior.service.impl;

import com.kamijoucen.batchtask.behavior.service.IdGenerator;
import com.kamijoucen.batchtask.config.BaseBehavior;
import com.kamijoucen.batchtask.config.BatchTaskConfiguration;

public class DBIncrementIdGeneratorImpl extends BaseBehavior implements IdGenerator {

    public DBIncrementIdGeneratorImpl(BatchTaskConfiguration configuration) {
        super(configuration);
    }

    @Override
    public Object nextId() {
        return "";
    }

}
