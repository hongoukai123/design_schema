package com.kai.chap.mapper;

import com.kai.chap.po.UserInfo;

import java.sql.SQLException;
import java.util.List;

public interface UserInfoMapper {


    /**
     * 根据用户名获取用户对象
     * @param username 用户名
     * @return 用户对象
     * @throws SQLException
     */
    UserInfo findByName(String username);

    /**
     * 添加用户
     * @param userInfo 用户对象
     * @return
     */
    int save(UserInfo userInfo);

    /**
     * 修改用户
     * @param userInfo 用户对象
     * @return
     */
    int update(UserInfo userInfo);

    /**
     * 删除用户
     * @param id 用户ID
     * @return
     */
    int delete(String id);

    /**
     * 根据条件对象获取分页用户信息
     * @param userInfo 用户对象
     * @return 用户集合列表
     */
    List<UserInfo> getPageListByObj(UserInfo userInfo);

    /**
     * 根据条件统计用户总数
     * @param userInfo 用户对象
     * @return
     */
    Long countByObj(UserInfo userInfo);

}