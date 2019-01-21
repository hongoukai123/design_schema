package com.kai.chap.mapper;

import com.kai.chap.po.UserRole;

import java.util.List;

public interface UserRoleMapper {

    int save(UserRole record);

    UserRole selectById(Integer id);

    int update(UserRole record);

    int delete(Integer id);

    List<UserRole> selectByObj(UserRole record);
}