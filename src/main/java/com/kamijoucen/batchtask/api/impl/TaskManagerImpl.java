package com.kamijoucen.batchtask.api.impl;

import com.kamijoucen.batchtask.api.TaskManager;
import com.kamijoucen.batchtask.config.BaseBehavior;
import com.kamijoucen.batchtask.config.BatchTaskConfiguration;

public class TaskManagerImpl extends BaseBehavior implements TaskManager {

    public TaskManagerImpl(BatchTaskConfiguration configuration) {
        super(configuration);
    }
    
}
