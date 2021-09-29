package com.doit.service.impl;

import com.doit.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>描述: [] </p>
 * <p>创建时间: 2021/09/29 上午 10:50 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Service("userDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库获取用户数据
        com.doit.entity.User user = userService.queryByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        // 用户权限集合
        List<GrantedAuthority> author = AuthorityUtils.commaSeparatedStringToAuthorityList("user");

        return new User(username, user.getPassword(), author);
    }
}
