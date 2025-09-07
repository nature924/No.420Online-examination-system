package com.shanzhu.oe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.Teacher;

import java.util.List;

/**
 * 教师 服务层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
public interface TeacherService {

    /**
     * 查询教师 分页
     *
     * @param page 分页对象
     * @return 教师列表
     */
    IPage<Teacher> findAll(Page<Teacher> page);

    List<Teacher> findAll();

    /**
     * 通过教师id查询
     *
     * @param teacherId 教师id
     * @return 教师
     */
    Teacher findById(Integer teacherId);

    /**
     * 删除教师
     *
     * @param teacherId 教师id
     * @return 结果
     */
    Integer deleteById(Integer teacherId);

    /**
     * 更新教师
     *
     * @param teacher 教师信息
     * @return 结果
     */
    Integer update(Teacher teacher);

    /**
     * 添加教师
     *
     * @param teacher 教师信息
     * @return 结果
     */
    Integer add(Teacher teacher);
}
