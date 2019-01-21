package com.kai.chap.service.user.impl;

import com.kai.chap.mapper.PermissionInfoMapper;
import com.kai.chap.po.PermissionInfo;
import com.kai.chap.service.user.IPermissionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 许可业务实现类
 *
 * @author hongok
 * @since 2018-12-29 16:23:55
 */
@Service("permissionInfoService")
public class PermissionInfoServiceImpl implements IPermissionInfoService {

    @Autowired
    private PermissionInfoMapper permissionInfoMapper;

    @Override
    public int save(PermissionInfo record) {
        return 0;
    }

    @Override
    public PermissionInfo selectById(Integer id) {
        return null;
    }

    @Override
    public int update(PermissionInfo record) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public List<PermissionInfo> selectByObj(PermissionInfo record) {
        return null;
    }

}
