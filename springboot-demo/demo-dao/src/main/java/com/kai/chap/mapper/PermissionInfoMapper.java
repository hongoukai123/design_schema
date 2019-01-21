package com.kai.chap.mapper;

import com.kai.chap.po.PermissionInfo;

import java.util.List;

public interface PermissionInfoMapper {

    int save(PermissionInfo record);

    PermissionInfo selectById(Integer id);

    int update(PermissionInfo record);

    int delete(Integer id);

    List<PermissionInfo> selectByObj(PermissionInfo record);
}