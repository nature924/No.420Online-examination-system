package com.shanzhu.oe.vo;

import com.shanzhu.oe.entity.FillQuestion;
import com.shanzhu.oe.entity.JudgeQuestion;
import com.shanzhu.oe.entity.MultiQuestion;
import lombok.Data;

/**
 * 题目 接口返回对象
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Data
public class QuestionVO {

    /**
     * 题目类型
     */
    private String type;

    /**
     * 填空题
     */
    private FillQuestion fillQuestion;

    /**
     * 判断题
     */
    private JudgeQuestion judgeQuestion;

    /**
     * 选择题
     */
    private MultiQuestion multiQuestion;

}
