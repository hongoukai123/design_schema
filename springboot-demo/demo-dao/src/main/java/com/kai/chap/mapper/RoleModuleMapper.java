package com.kai.chap.mapper;

import com.kai.chap.po.RoleModule;

import java.util.List;

public interface RoleModuleMapper {

    int save(RoleModule record);

    RoleModule selectById(Integer id);

    int update(RoleModule record);

    int delete(Integer id);

    List<RoleModule> selectByObj(RoleModule record);
}