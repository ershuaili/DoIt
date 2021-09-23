package com.doit.controller;

import com.doit.entity.User;
import com.doit.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return result
     */
    @GetMapping("login")
    public String login(String userName, String password) {
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        // 登录验证
        try {
            // 创建用户token    验证登录
            subject.login(new UsernamePasswordToken(userName, password));
            return "redirect:/";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误!");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "login";
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
    @GetMapping("register")
    public String register(User user) {
        try {
            userService.insert(user);
            return "redirect:login";
        } catch (Exception e) {
            e.printStackTrace();
            return "register";
        }
    }
}
