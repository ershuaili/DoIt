package com.doit.controller;

import com.doit.entity.Step;
import com.doit.entity.Task;
import com.doit.service.StepService;
import com.doit.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    @Resource
    private TaskService taskService;
    @Resource
    private StepService stepService;

    /**
     * 前端首页展示任务和任务详细信息列表
     *
     * @return index
     */
    @GetMapping("/")
    public String index() {
        return "doit/index";
    }

    /**
     * 查询所有步骤
     *
     * @return 步骤列表
     */
    @GetMapping("/tasks")
    @ResponseBody
    public List<Task> queryTask() {
        return taskService.queryToday();
    }

    /**
     * 查询指定任务的步骤
     *
     * @param id 任务id
     * @return 步骤实体
     */
    @GetMapping("/steps")
    @ResponseBody
    public List<Step> queryStep(Integer id) {
        return stepService.queryStepByTaskId(id);
    }

    /**
     * 增加一个任务
     *
     * @param task 任务对象
     * @return 任务对象实体
     */
    @PostMapping("/taskInput")
    @ResponseBody
    public Task taskInsert(Task task) {
        return taskService.insert(task);
    }

    /**
     * 增加一个步骤
     *
     * @param step 步骤对象
     * @return 步骤对象实体
     */
    @PostMapping("/stepInput")
    @ResponseBody
    public Step stepInsert(Step step) {
        return stepService.insert(step);
    }

    /**
     * 删除一个任务
     *
     * @param id 任务id
     * @return 删除成功
     */
    @PostMapping("/taskDelete")
    @ResponseBody
    public boolean taskDelete(Integer id) {
        return taskService.deleteById(id);
    }

    /**
     * 删除一个步骤
     *
     * @param id 步骤id
     * @return 删除成功
     */
    @PostMapping("/stepDelete")
    @ResponseBody
    public boolean stepDelete(Integer id) {
        return stepService.deleteById(id);
    }

    /**
     * 修改一个任务
     *
     * @param task 任务对象
     * @return 修改成功
     */
    @PostMapping("/taskUpdate")
    @ResponseBody
    public Task taskUpdate(Task task) {
        return taskService.update(task);
    }
}
