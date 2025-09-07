package com.shanzhu.oe.service;

import com.shanzhu.oe.entity.Admin;
import com.shanzhu.oe.entity.Student;
import com.shanzhu.oe.entity.Teacher;

/**
 * 用户登录 服务层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
public interface LoginService {

    /**
     * 管理员用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录用户信息
     */
    Admin adminLogin(Integer username, String password);

    /**
     * 教师用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录用户信息
     */
    Teacher teacherLogin(Integer username, String password);

    /**
     * 学生用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录用户信息
     */
    Student studentLogin(Integer username, String password);
}
