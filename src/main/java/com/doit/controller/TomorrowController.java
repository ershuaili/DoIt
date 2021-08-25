package com.doit.controller;

import com.doit.entity.Task;
import com.doit.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>描述: [] </p>
 * <p>创建时间: 2021/07/28 下午 11:13 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Controller
@RequestMapping("/tom")
public class TomorrowController {
    @Resource
    private TaskService taskService;

    /**
     * 页面转跳
     *
     * @return 返回明天页面
     */
    @GetMapping
    public String tomorrow() {
        return "/tomorrow";
    }

    /**
     * 获取明天任务列表
     *
     * @return 任务列表
     */
    @GetMapping("/queryTomorrowTasks")
    @ResponseBody
    public List<Task> queryTomorrowTasks() {
        return taskService.queryTomorrow();
    }
}
