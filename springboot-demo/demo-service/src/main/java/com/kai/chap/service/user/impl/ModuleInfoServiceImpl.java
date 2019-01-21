package com.kai.chap.service.user.impl;

import com.kai.chap.mapper.ModuleInfoMapper;
import com.kai.chap.po.ModuleInfo;
import com.kai.chap.service.user.IModuleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色信息业务实现类
 *
 * @author hongok
 * @since 2018-12-29 15:25:09
 */
@Service("moduleInfoService")
public class ModuleInfoServiceImpl implements IModuleInfoService {

    @Autowired
    private ModuleInfoMapper moduleInfoMapper;

    @Override
    public int save(ModuleInfo record) {
        return moduleInfoMapper.save(record);
    }

    @Override
    public ModuleInfo selectById(Integer id) {
        return moduleInfoMapper.selectById(id);
    }

    @Override
    public int update(ModuleInfo record) {
        return moduleInfoMapper.update(record);
    }

    @Override
    public int delete(Integer id) {
        return moduleInfoMapper.delete(id);
    }

    @Override
    public List<ModuleInfo> selectByObj(ModuleInfo record) {
        return moduleInfoMapper.selectByObj(record);
    }
}
