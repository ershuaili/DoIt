package com.doit.service;

import com.doit.entity.User;

/**
 * (User)表服务接口
 *
 * @author 李二帅
 * @date 2021-09-08 21:08:36
 */
public interface UserService {

    /**
     * 通过昵称查询单条数据
     *
     * @param name 昵称
     * @return 实例对象
     */
    User queryByName(String name);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    void insert(User user);
}
