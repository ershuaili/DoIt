package com.doit.service.impl;

import com.doit.entity.Step;
import com.doit.mapper.StepMapper;
import com.doit.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Step)表服务实现类
 *
 * @author 李二帅
 * @since 2021-07-31 16:08:44
 */
@Service("stepService")
public class StepServiceImpl implements StepService {
    @Autowired
    private StepMapper stepMapper;

    /**
     * 查询所有数据
     *
     * @return 实例对象列表
     */
    @Override
    public List<Step> queryAll() {
        return this.stepMapper.queryAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Step queryById(Integer id) {
        return this.stepMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param step 实例对象
     * @return 实例对象
     */
    @Override
    public Step insert(Step step) {
        this.stepMapper.insert(step);
        return step;
    }

    /**
     * 修改数据
     *
     * @param step 实例对象
     * @return 实例对象
     */
    @Override
    public Step update(Step step) {
        this.stepMapper.update(step);
        return this.queryById(step.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.stepMapper.deleteById(id) > 0;
    }
}
