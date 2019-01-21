package com.kai.chap.service.user;

import com.kai.chap.po.RoleInfo;

import java.util.List;

public interface IRoleInfoService {

    int save(RoleInfo record);

    RoleInfo selectById(Integer id);

    int update(RoleInfo record);

    int delete(Integer id);

    List<RoleInfo> selectByObj(RoleInfo record);

}
