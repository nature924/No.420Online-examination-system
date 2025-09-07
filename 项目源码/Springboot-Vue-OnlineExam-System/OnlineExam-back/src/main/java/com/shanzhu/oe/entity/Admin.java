package com.shanzhu.oe.entity;

import lombok.Data;

/**
 * 管理员
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Data
public class Admin {

    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 管理员名字
     */
    private String adminName;

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