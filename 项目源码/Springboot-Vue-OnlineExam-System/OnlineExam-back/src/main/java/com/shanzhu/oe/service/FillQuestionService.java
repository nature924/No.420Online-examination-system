package com.shanzhu.oe.service;

import com.shanzhu.oe.entity.FillQuestion;

import java.util.List;

/**
 * 填空题 服务层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
public interface FillQuestionService {

    /**
     * 通过试卷id查询问题
     *
     * @param paperId 试卷id
     * @return 问题
     */
    List<FillQuestion> findByIdAndType(Integer paperId);


    /**
     * 查询最后一条填空题
     *
     * @return 最后一条填空题
     */
    FillQuestion findOnlyQuestionId();

    /**
     * 添加填空题
     *
     * @param fillQuestion 填空题内容
     * @return 结果
     */
    Integer add(FillQuestion fillQuestion);

    /**
     * 通过学科查询
     *
     * @param subject 学科查询
     * @param pageNo 分页数
     * @return 题目
     */
    List<Integer> findBySubject(String subject,Integer pageNo);

    /**
     * 编辑填空题
     *
     * @param fillQuestion 填空题内容
     * @return 结果
     */
    Integer edit(FillQuestion fillQuestion);
}
