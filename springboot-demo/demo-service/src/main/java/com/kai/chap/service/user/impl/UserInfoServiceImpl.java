package com.kai.chap.service.user.impl;

import com.kai.chap.code.StateCode;
import com.kai.chap.mybatis.UUIDGenerator;
import com.kai.chap.po.UserInfo;
import com.kai.chap.service.user.IUserInfoService;
import com.kai.chap.mapper.UserInfoMapper;
import com.kai.chap.utils.SaltUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户信息业务实现类
 *
 * @author hongok
 * @since 2018-11-8 13:59:41
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findByName(String username){
        return userInfoMapper.findByName(username);
    }

    @Override
    public int save(UserInfo userInfo) {
        userInfo.setId(UUIDGenerator.getUUID());
        userInfo.setCreateTime(new Date());
        userInfo.setPassword(SaltUtil.getSaltPassword(userInfo.getUsername(), userInfo.getPassword()));
        userInfo.setStatus(StateCode.START_USING);
        return userInfoMapper.save(userInfo);
    }

    @Override
    public int update(UserInfo userInfo) {
        return userInfoMapper.update(userInfo);
    }

    @Override
    public int delete(String id) {
        return userInfoMapper.delete(id);
    }

    @Override
    public List<UserInfo> getPageListByObj(UserInfo userInfo) {
        return userInfoMapper.getPageListByObj(userInfo);
    }

    @Override
    public Long countByObj(UserInfo userInfo) {
        return userInfoMapper.countByObj(userInfo);
    }
}
