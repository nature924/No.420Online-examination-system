package com.shanzhu.oe.serviceimpl;

import com.shanzhu.oe.entity.Admin;
import com.shanzhu.oe.entity.Student;
import com.shanzhu.oe.entity.Teacher;
import com.shanzhu.oe.mapper.LoginMapper;
import com.shanzhu.oe.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户登录 服务层实现类
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginMapper loginMapper;

    /**
     * 管理员用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录用户信息
     */
    @Override
    public Admin adminLogin(Integer username, String password) {
        return loginMapper.adminLogin(username,password);
    }

    /**
     * 教师登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录用户信息
     */
    @Override
    public Teacher teacherLogin(Integer username, String password) {
        return loginMapper.teacherLogin(username,password);
    }

    /**
     * 学生登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录用户信息
     */
    @Override
    public Student studentLogin(Integer username, String password) {
        return loginMapper.studentLogin(username,password);
    }
}
