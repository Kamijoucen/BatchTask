package com.kamijoucen.batchtask.config;

import com.kamijoucen.powerstruct.context.RuntimeContext;
import com.kamijoucen.powerstruct.exe.Exe;
import com.kamijoucen.powerstruct.interceptor.AbstractExeInterceptor;

public class ContextInterceptor extends AbstractExeInterceptor {

    private final BatchTaskConfiguration configuration;
    
    public ContextInterceptor(BatchTaskConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <R> R execute(Exe<R> exe, RuntimeContext ctx) {
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
