package com.kai.chap.service.user.impl;

import com.kai.chap.mapper.RolePermissionMapper;
import com.kai.chap.po.RolePermission;
import com.kai.chap.service.user.IRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色许可业务实现类
 *
 * @author hongok
 * @since 2018-12-29 16:23:08
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements IRolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public int save(RolePermission record) {
        return 0;
    }

    @Override
    public RolePermission selectById(Integer id) {
        return null;
    }

    @Override
    public int update(RolePermission record) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public List<RolePermission> selectByObj(RolePermission record) {
        return null;
    }
}
