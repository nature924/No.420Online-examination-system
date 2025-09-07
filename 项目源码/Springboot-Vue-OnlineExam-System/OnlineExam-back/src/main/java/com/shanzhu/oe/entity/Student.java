package com.shanzhu.oe.entity;

import lombok.Data;

/**
 * 学生
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Data
public class Student {

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 年级
     */
    private String grade;

    /**
     * 专业
     */
    private String major;

    /**
     * 班级
     */
    private String clazz;

    /**
     * 学院
     */
    private String institute;

    /**
     * 性别
     */
    private String sex;

    /**
     * 电话
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 身份证
     */
    private String cardId;

    /**
     * 角色
     */
    private String role;
}