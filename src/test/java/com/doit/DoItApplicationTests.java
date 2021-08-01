package com.doit;

import com.doit.entity.Task;
import com.doit.service.StepService;
import com.doit.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DoItApplicationTests {

    @Autowired
    private TaskService taskService;
    @Autowired
    private StepService stepService;

    @Test
    void contextLoads() {
        // System.out.println(taskService.queryAll());
        // System.out.println(stepService.queryAll());
        // System.out.println(stepService.queryStepByTaskId(1));
        Task task1 = new Task();
        task1.setTaskName("喝茶");
        taskService.insert(task1);
    }

}
