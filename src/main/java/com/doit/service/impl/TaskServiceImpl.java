package com.doit.service.impl;

import com.doit.entity.Task;
import com.doit.mapper.TaskMapper;
import com.doit.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Task)表服务实现类
 *
 * @author 李二帅
 * @since 2021-07-31 16:08:44
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Autowired
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
     * @return 实例对象
     */
    @Override
    public Task insert(Task task) {
        this.taskMapper.insert(task);
        return task;
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