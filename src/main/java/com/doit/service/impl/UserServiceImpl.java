package com.doit.service.impl;

import com.doit.entity.User;
import com.doit.mapper.UserMapper;
import com.doit.service.UserService;
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
    public User insert(User user) {
        this.userMapper.insert(user);
        return user;
    }

}
