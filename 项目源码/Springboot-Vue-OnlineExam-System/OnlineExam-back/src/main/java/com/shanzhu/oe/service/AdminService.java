package com.shanzhu.oe.service;

import com.shanzhu.oe.entity.Admin;

import java.util.List;

/**
 * 管理员 服务层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
public interface AdminService {

    /**
     * 查询所有管理员
     *
     * @return 管理员
     */
    List<Admin> findAll();

    /**
     * 通过管理员id查询
     *
     * @param adminId 管理员id
     * @return 管理员
     */
    Admin findById(Integer adminId);

    /**
     * 通过管理员id删除
     *
     * @param adminId 管理员id
     * @return 结果
     */
    Integer deleteById(Integer adminId);

    /**
     * 更新管理员
     *
     * @param admin 管理员信息
     * @return 结果
     */
    Integer update(Admin admin);

    /**
     * 添加管理员
     *
     * @param admin 管理员信息
     * @return 结果
     */
    Integer add(Admin admin);

    /**
     * 更新密码
     *
     * @param adminId 管理员id
     * @param newPsw 新密码
     * @param oldPsw 旧密码
     * @return 结果
     */
    Object resetPsw(Integer adminId, String newPsw, String oldPsw);
}
