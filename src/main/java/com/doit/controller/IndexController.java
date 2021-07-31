package com.doit.controller;

import com.doit.entity.Task;
import com.doit.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>创建时间: @date 2021/07/24 下午 06:42 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Controller
@RequestMapping("/")
public class IndexController {
    /**
     * 服务对象
     */
    @Autowired
    private TaskService taskService;

    public String index(Model model) {

        List<Task> tasks = taskService.queryAll();
        model.addAttribute("tasks", tasks);
        return "/index";
    }
}
