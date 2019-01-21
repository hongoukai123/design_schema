package com.kai.chap.mapper;

import com.kai.chap.po.ModuleInfo;

import java.util.List;

public interface ModuleInfoMapper {

    int save(ModuleInfo record);

    ModuleInfo selectById(Integer id);

    int update(ModuleInfo record);

    int delete(Integer id);

    List<ModuleInfo> selectByObj(ModuleInfo record);
}