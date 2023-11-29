package com.kamijoucen.batchtask.domain;

public enum ContextPropertyEnum {

    SQL_SESSION_MANAGER("SQL_SESSION_FACTORY"),

    BATCH_TASK_CONFIGURATION("BATCH_TASK_CONFIGURATION"),
    
    ;

    private ContextPropertyEnum(String name) {
        this.name = name;
    }
    
    public final String name;
    
}
