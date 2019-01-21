package com.kai.chap.service.user;

import com.kai.chap.po.UserRole;

import java.util.List;

public interface IUserRoleService {

    int save(UserRole record);

    UserRole selectById(Integer id);

    int update(UserRole record);

    int delete(Integer id);

    List<UserRole> selectByObj(UserRole record);

}
