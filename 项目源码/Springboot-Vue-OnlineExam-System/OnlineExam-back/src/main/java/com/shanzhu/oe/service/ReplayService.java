package com.shanzhu.oe.service;

import com.shanzhu.oe.entity.Replay;

import java.util.List;

/**
 * 回复 服务层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
public interface ReplayService {

    /**
     * 通过留言id查询回复
     *
     * @param messageId 留言id
     * @return 回复
     */
    List<Replay> findAllById(Integer messageId);

    /**
     * 删除回复
     *
     * @param replayId 回复id
     * @return 结果
     */
    Integer delete(Integer replayId);

    /**
     * 更新回复
     *
     * @param replay 回复内容
     * @return 结果
     */
    Integer update(Replay replay);

    /**
     * 添加回复
     *
     * @param replay 回复内容
     * @return 结果
     */
    Integer add(Replay replay);
}
