package com.doit.service;

import com.doit.entity.Step;

import java.util.List;

/**
 * (Step)表服务接口
 *
 * @author 李二帅
 * @date 2021-07-31 16:08:43
 */
public interface StepService {

    /**
     * 查询所有数据
     *
     * @return 实例对象列表
     */
    List<Step> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Step queryById(Integer id);

    /**
     * 查询单个任务的步骤
     *
     * @param taskId 任务id
     * @return 实例对象
     */
    List<Step> queryStepByTaskId(Integer taskId);

    /**
     * 新增数据
     *
     * @param step 实例对象
     * @return 实例对象
     */
    Step insert(Step step);

    /**
     * 修改数据
     *
     * @param step 实例对象
     * @return 实例对象
     */
    Step update(Step step);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
