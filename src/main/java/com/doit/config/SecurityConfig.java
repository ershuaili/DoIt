package com.doit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * <p>描述: [开启WebSecurity模式] </p>
 * <p>创建时间: 2021/09/28 下午 10:12 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private UserDetailsService userDetailsService;

    /**
     * 授权
     *
     * @param http http
     * @throws Exception exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 无权限页面
        http.exceptionHandling().accessDeniedPage("/unPermission");
        // 定制请求的授权规则
        http.authorizeRequests()
                // 注册页面
                .antMatchers("/register").permitAll()
                // 注册表单提交页面
                .antMatchers("/userRegister").permitAll()
                // 其他页面!!!注意提供用户权限
                .antMatchers("/**").hasAuthority("user");
        // 自定义登录界面
        http.formLogin()
                // 登录页面
                .loginPage("/login")
                // 登录路径
                .loginProcessingUrl("/login")
                // 成功路径
                .defaultSuccessUrl("/").permitAll();
        // 开启退出
        http.logout();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }
}
