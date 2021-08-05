package com.doit.controller;

import com.doit.entity.Task;
import com.doit.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * (Task)表控制层
 *
 * @author 李二帅
 * @date 2021-07-31 16:08:44
 */
@Controller
@RequestMapping("/tas")
public class TaskController {
    /**
     * 服务对象
     */
    @Autowired
    private TaskService taskService;

    @RequestMapping
    public String tasks() {
        return "task";
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Task selectOne(Integer id) {
        return this.taskService.queryById(id);
    }

}
