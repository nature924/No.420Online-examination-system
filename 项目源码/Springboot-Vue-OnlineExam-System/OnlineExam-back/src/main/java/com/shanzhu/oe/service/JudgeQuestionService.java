package com.shanzhu.oe.service;

import com.shanzhu.oe.entity.JudgeQuestion;

import java.util.List;

/**
 * 判断题 服务层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
public interface JudgeQuestionService {

    /**
     * 通过试卷id查询问题
     *
     * @param paperId 试卷id
     * @return 问题
     */
    List<JudgeQuestion> findByIdAndType(Integer paperId);

    /**
     * 查询最后一个判断题id
     *
     * @return 最后一个判断题
     */
    JudgeQuestion findOnlyQuestionId();

    /**
     * 添加判断题
     *
     * @param judgeQuestion 判断题信息
     * @return 结果
     */
    Integer add(JudgeQuestion judgeQuestion);

    /**
     * 通过学科查询
     *
     * @param subject 学科
     * @param pageNo 分页数
     * @return 题目id
     */
    List<Integer> findBySubject(String subject,Integer pageNo);

    /**
     * 编辑判断题
     *
     * @param judgeQuestion 判断题
     * @return 结果
     */
    Integer edit(JudgeQuestion judgeQuestion);
}
