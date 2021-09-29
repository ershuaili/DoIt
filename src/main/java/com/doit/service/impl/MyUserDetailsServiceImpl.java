package com.doit.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 用户权限集合
        List<GrantedAuthority> author = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");

        return new User("789", new BCryptPasswordEncoder().encode("789"), author);
    }
}
