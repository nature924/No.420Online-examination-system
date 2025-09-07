package com.shanzhu.oe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.ExamManage;

import java.util.List;

/**
 * 考试管理 服务层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
public interface ExamManageService {

    /**
     * 查询所有考试
     *
     * @return 考试列表
     */
    List<ExamManage> findAll();

    /**
     * 查询考试 分页
     *
     * @param page 分页对象
     * @return 考试列表
     */
    IPage<ExamManage> findAll(Page<ExamManage> page);

    /**
     * 根据考试编号查询考试信息
     *
     * @param examCode 考试编好
     * @return 考试信息
     */
    ExamManage findById(Integer examCode);

    /**
     * 根据考试编号删除
     *
     * @param examCode 考试编号
     */
    Integer delete(Integer examCode);

    /**
     * 更新考试信息
     *
     * @param examManage 考试信息
     */
    Integer update(ExamManage examManage);

    /**
     * 添加考试信息
     *
     * @param examManage 考试信息
     */
    Integer add(ExamManage examManage);

    /**
     * 查询最后一条记录的paperId,返回给前端达到自增效果
     *
     * @return 最后一条记录
     */
    ExamManage findOnlyPaperId();


}
