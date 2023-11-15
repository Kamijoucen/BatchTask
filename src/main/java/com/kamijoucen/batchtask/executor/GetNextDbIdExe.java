package com.kamijoucen.batchtask.executor;

import com.kamijoucen.powerstruct.context.RuntimeContext;
import com.kamijoucen.powerstruct.exe.Exe;

public class GetNextDbIdExe implements Exe<String> {
    
    private String lastId = null;

    private String nextId = null;
    
    
    @Override
    public synchronized String execute(RuntimeContext ctx) {
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
