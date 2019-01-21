package com.kai.chap.service.user.impl;

import com.kai.chap.mapper.UserRoleMapper;
import com.kai.chap.po.UserRole;
import com.kai.chap.service.user.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色业务实现类
 *
 * @author hongok
 * @since 2018-12-29 14:30:06
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public int save(UserRole record) {
        return userRoleMapper.save(record);
    }

    @Override
    public UserRole selectById(Integer id) {
        return userRoleMapper.selectById(id);
    }

    @Override
    public int update(UserRole record) {
        return userRoleMapper.update(record);
    }

    @Override
    public int delete(Integer id) {
        return userRoleMapper.delete(id);
    }

    @Override
    public List<UserRole> selectByObj(UserRole record) {
        return userRoleMapper.selectByObj(record);
    }
}
