package com.shanzhu.oe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.Score;

import java.util.List;

/**
 * 分数 服务层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
public interface ScoreService {

    /**
     * 添加学生成绩
     *
     * @param score 学生成绩
     * @return 考试成绩
     */
    Integer add(Score score);

    /**
     * 查询所有考试成绩
     *
     * @return 考试分数
     */
    List<Score> findAll();

    /**
     * 查询考试成绩 分页
     *
     * @param page 分页对象
     * @param studentId 学生id
     * @return 结果
     */
    IPage<Score> findById(Page page, Integer studentId);

    /**
     * 查询考试成绩 不分页
     *
     * @param studentId 学生id
     * @return 考试成绩
     */
    List<Score> findById(Integer studentId);

    /**
     * 通过考试编号 查询学生成绩
     *
     * @param examCode 考试编号
     * @return 考试成绩
     */
    List<Score> findByExamCode(Integer examCode);
}
