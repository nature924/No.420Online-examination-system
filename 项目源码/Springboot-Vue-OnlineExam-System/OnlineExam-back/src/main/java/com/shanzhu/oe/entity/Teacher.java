package com.shanzhu.oe.entity;

import lombok.Data;

/**
 * 教师
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Data
public class Teacher {

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 教师名字
     */
    private String teacherName;

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
     * 职称
     */
    private String type;

    /**
     * 角色
     */
    private String role;

}