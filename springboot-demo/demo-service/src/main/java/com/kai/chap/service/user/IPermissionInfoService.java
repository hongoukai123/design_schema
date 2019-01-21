package com.kai.chap.service.user;

import com.kai.chap.po.PermissionInfo;

import java.util.List;

public interface IPermissionInfoService {

    int save(PermissionInfo record);

    PermissionInfo selectById(Integer id);

    int update(PermissionInfo record);

    int delete(Integer id);

    List<PermissionInfo> selectByObj(PermissionInfo record);

}
