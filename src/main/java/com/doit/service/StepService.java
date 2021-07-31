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
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Step queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Step> queryAllByLimit(int offset, int limit);

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
