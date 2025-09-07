package com.shanzhu.oe.service;

import com.shanzhu.oe.entity.MultiQuestion;

import java.util.List;

/**
 * 选择题 服务层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
public interface MultiQuestionService {

    /**
     * 通过试卷id 查询试卷
     *
     * @param paperId 试卷id
     * @return 问题
     */
    List<MultiQuestion> findByIdAndType(Integer paperId);

    /**
     * 通过id查询选择题
     *
     * @return 选择题
     */
    MultiQuestion findOnlyQuestionId();

    /**
     * 添加选择题
     *
     * @param multiQuestion 选择题信息
     * @return 结果
     */
    Integer add(MultiQuestion multiQuestion);

    /**
     * 通过学科查询
     *
     * @param subject 学科
     * @param pageNo 分页数
     * @return 题目id
     */
    List<Integer> findBySubject(String subject,Integer pageNo);

    /**
     * 编辑选择题
     *
     * @param multiQuestion 选择题信息
     * @return 结果
     */
    Integer edit(MultiQuestion multiQuestion);
}
