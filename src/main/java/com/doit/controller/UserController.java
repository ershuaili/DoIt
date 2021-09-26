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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String userLogin(String userName, String password, RedirectAttributes redirectAttributes) {
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        // 登录验证
        try {
            // 创建用户token    验证登录
            subject.login(new UsernamePasswordToken(userName, password));
            return "redirect:/";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "用户名错误");
            return "redirect:login";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "密码错误");
            return "redirect:login";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("服务器内部错误");
            return "error/500";
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

    /**
     * 根据用户名查询用户信息
     *
     * @param userName 用户名
     * @return 用户信息
     */
    @RequestMapping("queryUser")
    @ResponseBody
    public User queryUser(String userName) {
        return userService.queryByName(userName);
    }
}
