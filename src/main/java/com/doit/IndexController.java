package com.doit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 李二帅
 * @version 1.0
 * @date 2021/07/24 下午 06:42
 * @since 8.0
 */
@Controller
@RequestMapping
public class IndexController {

    public String index() {
        return "index";
    }
}
