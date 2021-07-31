package com.doit.controller;

import com.doit.entity.Step;
import com.doit.entity.Task;
import com.doit.service.StepService;
import com.doit.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>创建时间: @date 2021/07/24 下午 06:42 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Controller
public class IndexController {
    /**
     * 服务对象
     */
    @Autowired
    private TaskService taskService;
    @Autowired
    private StepService stepService;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "1", value = "id") Integer id, Model model) {

        List<Task> tasks = taskService.queryAll();
        List<Step> steps = stepService.queryStepByTaskId(id);

        model.addAttribute("tasks", tasks);
        model.addAttribute("steps", steps);
        return "index";
    }
}
