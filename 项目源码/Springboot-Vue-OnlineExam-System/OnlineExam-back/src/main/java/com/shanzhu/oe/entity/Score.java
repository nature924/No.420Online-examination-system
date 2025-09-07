package com.shanzhu.oe.entity;

import lombok.Data;

/**
 * 考试成绩
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Data
public class Score {

    /**
     * 考试编号
     */
    private Integer examCode;

    /**
     * 学号
     */
    private Integer studentId;

    /**
     * 课程名称
     */
    private String subject;

    /**
     * 平时成绩
     */
    private Integer ptScore;

    /**
     * 期末成绩
     */
    private Integer etScore;

    /**
     * 成绩分数
     */
    private Integer score;

    /**
     * 成绩编号
     */
    private Integer scoreId;

    /**
     * 答题日期
     */
    private String answerDate;

}

