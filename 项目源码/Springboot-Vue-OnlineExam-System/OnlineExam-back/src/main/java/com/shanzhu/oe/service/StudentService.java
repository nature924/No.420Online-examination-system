package com.shanzhu.oe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.Student;

/**
 * 学生 服务层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
public interface StudentService {

    /**
     * 查询学生 分页
     *
     * @param page      分页对象
     * @param name      学生姓名
     * @param grade     班级
     * @param tel       电话
     * @param institute 学院
     * @param major     专业
     * @param clazz     班级
     * @return 学生列表
     */
    IPage<Student> findAll(
            Page<Student> page, String name,
            String grade, String tel,
            String institute, String major, String clazz
    );

    /**
     * 通过学生id查询学生
     *
     * @param studentId 学生id
     * @return 学生
     */
    Student findById(Integer studentId);

    /**
     * 删除学生
     *
     * @param studentId 学生id
     * @return 结果
     */
    Integer deleteById(Integer studentId);

    /**
     * 更新学生
     *
     * @param student 学生信息
     * @return 结果
     */
    Integer update(Student student);

    /**
     * 添加学生
     *
     * @param student 学生信息
     * @return 结果
     */
    Integer add(Student student);

    /**
     * 更新密码
     *
     * @param student 学生信息
     * @return 结果
     */
    Integer updatePwd(Student student);
}
