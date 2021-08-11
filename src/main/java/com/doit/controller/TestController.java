package com.doit.controller;

import com.doit.entity.Step;
import com.doit.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>描述: [] </p>
 * <p>创建时间: 2021/08/10 上午 11:56 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@RestController
public class TestController {
    @Autowired
    private StepService stepService;

    /**
     * 查询指定任务的步骤
     *
     * @return 步骤实体
     */
    @ResponseBody
    @RequestMapping("/a")
    public List<Step> queryStep() {
        Integer id = 1;
        return stepService.queryStepByTaskId(id);
    }
}
