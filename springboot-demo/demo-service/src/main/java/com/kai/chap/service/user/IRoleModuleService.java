package com.kai.chap.service.user;

import com.kai.chap.po.RoleModule;

import java.util.List;

public interface IRoleModuleService {

    int save(RoleModule record);

    RoleModule selectById(Integer id);

    int update(RoleModule record);

    int delete(Integer id);

    List<RoleModule> selectByObj(RoleModule record);

}
