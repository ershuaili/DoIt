package com.doit.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>描述: [] </p>
 * <p>创建时间: 2021/09/09 上午 11:40 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping("login")
    public String login(String userName, String password, Model model) {
        // 获取用户数据
        Subject subject = SecurityUtils.getSubject();
        // 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        // 执行登录方法
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("e", e);
            return "login";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return "login";
        }
    }
}
