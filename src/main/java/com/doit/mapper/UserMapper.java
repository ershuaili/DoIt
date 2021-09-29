package com.doit.mapper;

import com.doit.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * (User)表数据库访问层
 *
 * @author 李二帅
 * @date 2021-09-08 21:08:36
 */
@Mapper
public interface UserMapper {

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
     * @return 影响行数
     */
    int insert(User user);
}

