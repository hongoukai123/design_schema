package com.kai.chap.service.user.impl;

import com.kai.chap.mapper.RoleModuleMapper;
import com.kai.chap.po.RoleModule;
import com.kai.chap.service.user.IRoleModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色模块业务实现类
 *
 * @author hongok
 * @since 2018-12-29 14:28:52
 */
@Service("roleModuleService")
public class RoleModuleServiceImpl implements IRoleModuleService {

    @Autowired
    private RoleModuleMapper roleModuleMapper;

    @Override
    public int save(RoleModule record) {
        return roleModuleMapper.save(record);
    }

    @Override
    public RoleModule selectById(Integer id) {
        return roleModuleMapper.selectById(id);
    }

    @Override
    public int update(RoleModule record) {
        return roleModuleMapper.update(record);
    }

    @Override
    public int delete(Integer id) {
        return roleModuleMapper.delete(id);
    }

    @Override
    public List<RoleModule> selectByObj(RoleModule record) {
        return roleModuleMapper.selectByObj(record);
    }
}
