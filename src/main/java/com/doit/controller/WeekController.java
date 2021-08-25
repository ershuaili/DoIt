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
 * <p>描述: [最近一周] </p>
 * <p>创建时间: 2021/07/28 下午 11:19 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Controller
@RequestMapping("/wee")
public class WeekController {

    @Resource
    private TaskService taskService;

    @GetMapping
    public String week() {
        return "week";
    }

    @GetMapping("/queryWeekTasks")
    @ResponseBody
    public List<Task> queryWeekTasks() {
        return taskService.queryWeek();
    }

}
