package com.kai.chap.service.user.impl;

import com.kai.chap.mapper.RoleInfoMapper;
import com.kai.chap.po.RoleInfo;
import com.kai.chap.service.user.IRoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色信息业务实现类
 *
 * @author hongok
 * @since 2018-12-29 15:25:09
 */
@Service("roleInfoService")
public class RoleInfoServiceImpl implements IRoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public int save(RoleInfo record) {
        return roleInfoMapper.save(record);
    }

    @Override
    public RoleInfo selectById(Integer id) {
        return roleInfoMapper.selectById(id);
    }

    @Override
    public int update(RoleInfo record) {
        return roleInfoMapper.update(record);
    }

    @Override
    public int delete(Integer id) {
        return roleInfoMapper.delete(id);
    }

    @Override
    public List<RoleInfo> selectByObj(RoleInfo record) {
        return roleInfoMapper.selectByObj(record);
    }
}
