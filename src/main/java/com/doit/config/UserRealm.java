package com.doit.config;


import com.doit.entity.User;
import com.doit.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>描述: [自定义realm] </p>
 * <p>创建时间: 2021/09/06 下午 04:02 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户的登录token
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 根据用户名查询用户
        User user = userService.queryByName(token.getUsername());
        // 如果用户为空
        if (user == null) {
            // 抛出异常 UnknownAccountException
            return null;
        }
        return new SimpleAuthenticationInfo("", user.getPassword(), "");
    }
}
