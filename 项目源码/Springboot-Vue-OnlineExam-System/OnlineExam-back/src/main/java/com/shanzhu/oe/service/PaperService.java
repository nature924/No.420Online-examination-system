package com.shanzhu.oe.service;

import com.shanzhu.oe.entity.PaperManage;

import java.util.List;

/**
 * 试卷 服务层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
public interface PaperService {

    /**
     * 查询所有试卷
     *
     * @return 试卷
     */
    List<PaperManage> findAll();

    /**
     * 添加试卷
     *
     * @param paperManage 试卷信息
     * @return 结果
     */
    Integer add(PaperManage paperManage);

    /**
     * 获取试卷总分
     *
     * @param paperId 试卷id
     * @return 分数
     */
    Integer getMaxScore(Integer paperId);

    /**
     * 删除试卷中的某条试题
     *
     * @param paperId 试卷id
     * @param type 题目类型。1选择，2填空，3判断
     * @param questionId 题目id
     */
    void delete(String paperId, String type, String questionId);
}
