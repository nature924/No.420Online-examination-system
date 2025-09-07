package com.shanzhu.oe.mapper;

import com.shanzhu.oe.entity.Replay;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 留言 持久层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Mapper
public interface ReplayMapper {

    /**
     * 通过留言id查询回复
     *
     * @param messageId 留言id
     * @return 回复
     */
    @Select("select messageId,replayId,replay,replayTime from replay where messageId = #{messageId}")
    List<Replay> findAllById(Integer messageId);

    /**
     * 删除回复
     *
     * @param replayId 回复id
     * @return 结果
     */
    @Delete("delete from replay where replayId = #{replayId}")
    Integer delete(Integer replayId);

    /**
     * 更新回复
     *
     * @param replay 回复内容
     * @return 结果
     */
    @Update("update replay set title = #{title}, replay = #{replay}, replayTime = #{replayTime} where replayId = " +
            "#{replayId}")
    Integer update(Replay replay);

    /**
     * 添加回复
     *
     * @param replay 回复内容
     * @return 结果
     */
    @Options(useGeneratedKeys = true, keyProperty = "replayId")
    @Insert("insert into replay(messageId,replay,replayTime) values(#{messageId}, #{replay},#{replayTime})")
    int add(Replay replay);
}
