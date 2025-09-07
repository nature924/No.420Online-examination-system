package com.shanzhu.oe.controller;

import com.shanzhu.oe.common.R;
import com.shanzhu.oe.entity.Admin;
import com.shanzhu.oe.entity.Login;
import com.shanzhu.oe.entity.Student;
import com.shanzhu.oe.entity.Teacher;
import com.shanzhu.oe.service.LoginService;
import com.shanzhu.oe.util.ApiResultHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录 控制层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /**
     * 用户登录
     *
     * @param login    用户信息
     * @param response http response
     * @return 登录用户信息
     */
    @PostMapping("/login")
    public R login(@RequestBody Login login, HttpServletResponse response) {
        Integer username = login.getUsername();
        String password = login.getPassword();

        //登录管理员
        Admin adminRes = loginService.adminLogin(username, password);
        if (adminRes != null) {
            Cookie token = new Cookie("rb_token", adminRes.getCardId());
            token.setPath("/");
            Cookie role = new Cookie("rb_role", "0");
            role.setPath("/");

            //将cookie对象加入response响应
            response.addCookie(token);
            response.addCookie(role);

            return ApiResultHandler.buildApiResult(200, "请求成功", adminRes);
        }

        //登录教师
        Teacher teacherRes = loginService.teacherLogin(username, password);
        if (teacherRes != null) {
            Cookie token = new Cookie("rb_token", teacherRes.getCardId());
            token.setPath("/");
            Cookie role = new Cookie("rb_role", "1");
            role.setPath("/");
            response.addCookie(token);
            response.addCookie(role);
            return ApiResultHandler.buildApiResult(200, "请求成功", teacherRes);
        }

        //登录选
        Student studentRes = loginService.studentLogin(username, password);
        if (studentRes != null) {
            Cookie token = new Cookie("rb_token", studentRes.getCardId());
            token.setPath("/");
            Cookie role = new Cookie("rb_role", "2");
            role.setPath("/");
            response.addCookie(token);
            response.addCookie(role);
            return ApiResultHandler.buildApiResult(200, "请求成功", studentRes);
        }

        return ApiResultHandler.buildApiResult(400, "请求失败", null);
    }

    /**
     * 登出
     *
     * @param response http response
     */
    @PostMapping("/logout")
    public void logout(HttpServletResponse response) {
        //清楚cookie里的token信息
        Cookie token = new Cookie("rb_token", null);
        token.setPath("/");
        token.setMaxAge(0);
        Cookie role = new Cookie("rb_role", null);
        role.setPath("/");
        role.setMaxAge(0);
        response.addCookie(token);
        response.addCookie(role);
    }
}
