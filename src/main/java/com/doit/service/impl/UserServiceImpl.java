package com.doit.service.impl;

import com.doit.entity.User;
import com.doit.mapper.UserMapper;
import com.doit.service.UserService;
import com.doit.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author 李二帅
 * @since 2021-09-08 21:08:37
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过昵称查询单条数据
     *
     * @param name 昵称
     * @return 实例对象
     */
    @Override
    public User queryByName(String name) {
        return this.userMapper.queryByName(name);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(User user) {
        //处理业务调用mapper
        //1.生成随机盐
        String salt = SaltUtils.getSalt(15);
        //2.将随机盐保存到数据
        user.setSalt(salt);
        //3.明文密码进行md5 + salt + hash散列
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setPassword(md5Hash.toHex());
        userMapper.insert(user);
    }

}
