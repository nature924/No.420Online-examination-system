package com.shanzhu.oe.vo;

import lombok.Data;

/**
 * 组卷
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Data
public class Item {

    /**
     * 科目
     */
    private String subject;

    /**
     * 试卷编号
     */
    private Integer paperId;

    /**
     * 选择题数量
     */
    private Integer changeNumber;

    /**
     * 填空题数量
     */
    private Integer fillNumber;

    /**
     * 判断题数量
     */
    private Integer judgeNumber;

}
