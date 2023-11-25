package com.kamijoucen.batchtask.behavior.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {

    String testQuery(String id);
    
}
