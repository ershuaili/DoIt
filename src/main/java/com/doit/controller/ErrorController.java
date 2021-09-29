package com.doit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>描述: [] </p>
 * <p>创建时间: 2021/09/29 下午 12:51 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Controller
@RequestMapping("/")
public class ErrorController {

    @RequestMapping("unPermission")
    public String toLogin() {
        return "error/unPermission";
    }
}
