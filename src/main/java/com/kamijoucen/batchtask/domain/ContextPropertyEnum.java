package com.kamijoucen.batchtask.domain;

public enum ContextPropertyEnum {

    SQL_SESSION_FACTORY("SQL_SESSION_FACTORY"),
    
    ;

    private ContextPropertyEnum(String name) {
        this.name = name;
    }
    
    public final String name;
    
}
