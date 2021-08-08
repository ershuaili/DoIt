package com.doit.controller;

import com.doit.entity.Step;
import com.doit.entity.Task;
import com.doit.service.StepService;
import com.doit.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    /**
     * 前端首页展示任务和任务详细信息列表
     *
     * @param id    步骤id
     * @param model 模型
     * @return index
     */
    @RequestMapping("/")
    public String index(@RequestParam(defaultValue = "1", value = "id") Integer id, Model model) {
        //查询所有任务
        List<Task> tasks = taskService.queryAll();
        //按照任务id查询任务步骤
        List<Step> steps = stepService.queryStepByTaskId(id);

        model.addAttribute("tasks", tasks);
        model.addAttribute("steps", steps);
        model.addAttribute("task", new Task());
        model.addAttribute("step", new Step());
        return "index";
    }

    /**
     * 增加一个任务
     *
     * @param task 任务对象
     * @return 首页
     */
    @PostMapping("taskInput")
    public String taskInsert(Task task, RedirectAttributes attributes) {
        Task insert = taskService.insert(task);
        if (insert == null) {
            attributes.addFlashAttribute("msg", "添加成功");
        } else {
            attributes.addFlashAttribute("msg", "添加失败");
        }
        return "redirect:/";
    }


    /**
     * 增加一个步骤
     *
     * @param step 步骤对象
     * @return 首页
     */
    @PostMapping("stepInput")
    public String stepInsert(Step step, RedirectAttributes attributes) {
        Step insert = stepService.insert(step);
        if (insert == null) {
            attributes.addFlashAttribute("msg", "添加成功");
        } else {
            attributes.addFlashAttribute("msg", "添加失败");
        }
        return "redirect:/";
    }
}
