package com.doit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>描述: [] </p>
 * <p>创建时间: 2021/07/28 下午 11:22 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Controller
@RequestMapping("/cal")
public class CalendarController {
    @RequestMapping
    public String calendar() {
        return "calendar";
    }
}
