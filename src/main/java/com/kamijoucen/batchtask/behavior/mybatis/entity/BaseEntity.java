package com.kamijoucen.batchtask.behavior.mybatis.entity;

import java.time.LocalDateTime;

public abstract class BaseEntity {

    private String id;

    private LocalDateTime createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    
}
