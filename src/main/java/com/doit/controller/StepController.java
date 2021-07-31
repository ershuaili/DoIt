package com.doit.controller;

import com.doit.entity.Step;
import com.doit.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * (Step)表控制层
 *
 * @author 李二帅
 * @date 2021-07-31 16:08:43
 */
@Controller
@RequestMapping("step")
public class StepController {
    /**
     * 服务对象
     */
    @Autowired
    private StepService stepService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Step selectOne(Integer id) {
        return this.stepService.queryById(id);
    }

}
