package com.doit.service;

import com.doit.entity.Task;

import java.util.List;

/**
 * (Task)表服务接口
 *
 * @author 李二帅
 * @date 2021-07-31 16:08:44
 */
public interface TaskService {

    /**
     * 查询所有数据
     *
     * @return 实例对象列表
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
     * @return 实例对象
     */
    Task insert(Task task);

    /**
     * 修改数据
     *
     * @param task 实例对象
     * @return 实例对象
     */
    Task update(Task task);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
