package com.doit.mapper;

import com.doit.entity.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Task)表数据库访问层
 *
 * @author 李二帅
 * @date 2021-07-31 16:08:44
 */
@Mapper
public interface TaskMapper {

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Task> queryAll();

    /**
     * 查询今天的任务
     *
     * @return 对象列表
     */
    List<Task> queryToday();


    /**
     * 查询明天任务
     *
     * @return 任务列表
     */
    List<Task> queryTomorrow();

    /**
     * 查询最近七天任务
     *
     * @return 任务列表
     */
    List<Task> queryWeek();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Task queryById(Integer id);

    /**
     * 新增数据
     *
     * @param task 实例对象
     * @return 影响行数
     */
    int insert(Task task);

    /**
     * 修改数据
     *
     * @param task 实例对象
     * @return 影响行数
     */
    int update(Task task);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

