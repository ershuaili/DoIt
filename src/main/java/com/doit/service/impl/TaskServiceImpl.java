package com.doit.service.impl;

import com.doit.entity.Task;
import com.doit.mapper.TaskMapper;
import com.doit.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Task)表服务实现类
 *
 * @author 李二帅
 * @since 2021-07-31 16:08:44
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Resource
    private TaskMapper taskMapper;

    /**
     * 查询所有数据
     *
     * @return 实例对象列表
     */
    @Override
    public List<Task> queryAll() {
        return this.taskMapper.queryAll();
    }

    /**
     * 查询今天的任务
     *
     * @return 对象列表
     */
    @Override
    public List<Task> queryToday() {
        return this.taskMapper.queryToday();
    }

    /**
     * 查询明天任务
     *
     * @return 任务列表
     */
    @Override
    public List<Task> queryTomorrow() {
        return this.taskMapper.queryTomorrow();
    }

    /**
     * 查询最近七天任务
     *
     * @return 任务列表
     */
    @Override
    public List<Task> queryWeek() {
        return this.taskMapper.queryWeek();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Task queryById(Integer id) {
        return this.taskMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param task 实例对象
     * @return 影响行数
     */
    @Override
    public Task insertDay(Task task) {
        this.taskMapper.insertDay(task);
        return this.queryById(task.getId());
    }

    /**
     * 新增数据 通过日历
     *
     * @param task 实例对象
     */
    @Override
    public int insertCal(Task task) {
        return this.taskMapper.insertCal(task);
    }

    /**
     * 修改数据
     *
     * @param task 实例对象
     * @return 实例对象
     */
    @Override
    public Task update(Task task) {
        this.taskMapper.update(task);
        return this.queryById(task.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.taskMapper.deleteById(id) > 0;
    }
}
