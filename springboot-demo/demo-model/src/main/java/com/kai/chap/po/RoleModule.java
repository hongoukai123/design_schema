package com.kai.chap.po;

import java.util.List;

/**
 * 角色模块表
 * @author hongok
 * @since 2018-12-29 14:25:40
 */
public class RoleModule {

    /**
     * ID
     */
    private Integer id;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 模块ID
     */
    private Integer moduleId;

    public RoleModule(){}

    public RoleModule(Integer roleId){
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

}