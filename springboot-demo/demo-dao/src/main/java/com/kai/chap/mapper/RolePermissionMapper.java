package com.kai.chap.mapper;

import com.kai.chap.po.RolePermission;

import java.util.List;

public interface RolePermissionMapper {

    int save(RolePermission record);

    RolePermission selectById(Integer id);

    int update(RolePermission record);

    int delete(Integer id);

    List<RolePermission> selectByObj(RolePermission record);
}