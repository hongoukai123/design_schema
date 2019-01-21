package com.kai.chap.service.user;

import com.kai.chap.po.RolePermission;

import java.util.List;

public interface IRolePermissionService {

    int save(RolePermission record);

    RolePermission selectById(Integer id);

    int update(RolePermission record);

    int delete(Integer id);

    List<RolePermission> selectByObj(RolePermission record);

}
