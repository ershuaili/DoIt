package com.doit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping
    public String tomorrow() {
        return "tomorrow";
    }
}
