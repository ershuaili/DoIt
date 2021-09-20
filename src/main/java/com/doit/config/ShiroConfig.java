package com.doit.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p> 描述: [自定义shiro]</p>
 * <p>
 * shiro三大对象
 * Subject: 用户
 * SecurityManager: 管理所有用户
 * Realm:   连接资源
 * </p>
 * <p>创建时间: 2021/09/06 下午 02:55 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Configuration
public class ShiroConfig {
    /**
     * ShiroFilterFactoryBean
     * 请求拦截
     *
     * @param defaultWebSecurityManager DefaultWebSecurityManager
     * @return ben
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        // 添加内置过滤器
        /*
            anon:无需认证就可以访问
            authc:必须认证了才能访问
            user:必须拥有记住我功能才能访问
            perms:拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();

        // 添加过滤器
        // 配置login页面为所有人可访问
        filterMap.put("/login", "anon");
        // 配置其他页面为受限资源页面
        filterMap.put("/**", "authc");

        bean.setFilterChainDefinitionMap(filterMap);

        bean.setLoginUrl("/login");
        return bean;
    }

    /**
     * DefaultWebSecurityManager
     *
     * @param userRealm 用户Realm
     * @return securityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        // 关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm对象,  需要自定义
     *
     * @return UserRealm()
     */
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
