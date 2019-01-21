package com.kai.chap.mapper;

import com.kai.chap.po.RoleInfo;

import java.util.List;

public interface RoleInfoMapper {

    int save(RoleInfo record);

    RoleInfo selectById(Integer id);

    int update(RoleInfo record);

    int delete(Integer id);

    List<RoleInfo> selectByObj(RoleInfo record);
}