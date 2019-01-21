package com.kai.chap.po;

/**
 * 用户角色表
 * @author hongok
 * @since 2018-12-29 14:23:26
 */
public class UserRole {

    /**
     * ID
     */
    private Integer id;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 用户名
     */
    private String username;

    public UserRole(){}

    public UserRole(String username){
        this.username = username;
    }

    public UserRole(Integer roleId){
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

}