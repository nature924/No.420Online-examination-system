package com.shanzhu.oe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.vo.AnswerVO;
import com.shanzhu.oe.vo.QuestionVO;

/**
 * 题库 服务层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
public interface AnswerService {

    /**
     * 查询题库 分页
     *
     * @param page 分页对象
     * @param subject 学科
     * @param section 章节
     * @param question 问题
     * @return 题目
     */
    IPage<AnswerVO> findAll(Page<AnswerVO> page, String subject, String section, String question);

    /**
     * 根据类型和id获取题目
     *
     * @param type 类型
     * @param questionId 题目id
     * @return 题目信息
     */
    QuestionVO findByIdAndType(String type, Long questionId);
}
