package com.kai.chap.common.shiro;

import com.kai.chap.common.jwt.JwtUtil;
import com.kai.chap.po.*;
import com.kai.chap.service.user.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义Realm
 * @author hongok
 * @since 2018-12-24 15:59:21
 */
@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IRoleInfoService roleInfoService;
    @Autowired
    private IPermissionInfoService permissionInfoService;
    @Autowired
    private IUserRoleService userRoleService;
    @Autowired
    private IRolePermissionService rolePermissionService;

    /**
     * 必须重写此方法，不然shiro会报错
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token){
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String username = JwtUtil.getUsername(principalCollection.toString());
        SimpleAuthorizationInfo simpleAuthenticationInfo = new SimpleAuthorizationInfo();
        List<UserRole> userRoleList = userRoleService.selectByObj(new UserRole(username));
        for (UserRole userRole : userRoleList) {
            RoleInfo roleInfo = roleInfoService.selectById(userRole.getRoleId());
            simpleAuthenticationInfo.addRole(roleInfo.getRoleName());
            List<RolePermission> rolePermissionList = rolePermissionService.selectByObj(new RolePermission(roleInfo.getId()));
            for (RolePermission rolePermission : rolePermissionList){
                PermissionInfo permissionInfo = permissionInfoService.selectById(rolePermission.getPermissionId());
                simpleAuthenticationInfo.addStringPermission(permissionInfo.getPermissionName());
            }
        }
        return simpleAuthenticationInfo;
    }

    /**
     * 验证用户名正确错误，错误直接输出异常
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户名
        String username = (String) token.getPrincipal();
        //通过用户账号查找用户对象
        UserInfo userInfo = userInfoService.findByName(username);
        if (userInfo == null){
            return null;
        }
        if (userInfo.getStatus().equals("1")){
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(username),//salt=username+salt
                this.getName()  //realm name
        );
        return authenticationInfo;
    }

}
