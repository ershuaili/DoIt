package com.doit.controller;

import com.doit.entity.User;
import com.doit.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author 李二帅
 * @date 2021-09-08 21:08:35
 */
@Controller
@RequestMapping("/")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 页面转跳
     *
     * @return 用户登录界面
     */
    @GetMapping("login")
    public String toLogin() {
        return "login";
    }

    /**
     * 页面转跳
     *
     * @return 用户注册界面
     */
    @GetMapping("register")
    public String toRegister() {
        return "register";
    }

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return result
     */
    @RequestMapping("userLogin")
    @ResponseBody
    public User userLogin(String userName, String password) {
        User user = userService.queryByName(userName);
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * 用户退出
     *
     * @return 视图
     */
    @GetMapping("logout")
    public String logout() {
        // 获取用户主体对象
        Subject subject = SecurityUtils.getSubject();
        // 用户退出
        subject.logout();
        return "redirect:login";
    }

    /**
     * 用户注册
     *
     * @return 视图
     */
    @RequestMapping("userRegister")
    public String register(User user) {
        try {
            userService.insert(user);
            return "redirect:login";
        } catch (Exception e) {
            e.printStackTrace();
            return "error/500";
        }
    }
}
