package com.doit;

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
        System.out.println(stepService.queryAll());
    }

}
