package com.doit.controller;

import com.doit.entity.Task;
import com.doit.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>描述: [日历视图] </p>
 * <p>创建时间: 2021/07/28 下午 11:22 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Controller
@RequestMapping("/cal")
public class CalendarController {
    @Resource
    private TaskService taskService;

    @RequestMapping
    public String calendar() {
        return "calendar";
    }

    /**
     * 查询所有任务
     *
     * @return 任务列表
     */
    @GetMapping("/queryAllCal")
    @ResponseBody
    public List<Task> queryTasks() {
        return taskService.queryAll();
    }

    /**
     * 通过日历增加一个任务
     *
     * @param task 任务对象
     * @return 任务对象实体
     */
    @PostMapping("/insertCal")
    @ResponseBody
    public int insertCal(Task task) {
        return taskService.insertCal(task);
    }

}
