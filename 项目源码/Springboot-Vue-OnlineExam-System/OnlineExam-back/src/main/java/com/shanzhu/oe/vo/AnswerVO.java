package com.shanzhu.oe.vo;

import lombok.Data;


/**
 * 题库 接口返回对象
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Data
public class AnswerVO {

    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 题目
     */
    private String question;

    /**
     * 科目
     */
    private String subject;

    /**
     * 分数
     */
    private String score;

    /**
     * 章节
     */
    private String section;

    /**
     * 难度等级
     */
    private String level;

    /**
     * 类型
     */
    private String type;


}
