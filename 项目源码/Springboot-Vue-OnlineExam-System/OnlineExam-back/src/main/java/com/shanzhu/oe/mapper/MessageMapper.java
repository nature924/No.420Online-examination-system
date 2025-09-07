package com.shanzhu.oe.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.Message;
import org.apache.ibatis.annotations.*;


/**
 * 留言 持久层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Mapper
public interface MessageMapper {

    /**
     * 留言查询 分页
     *
     * @param page 分页内容
     * @return 留言数据
     */
    @Select("select id,id as temp_id,title,content,time from message order by id desc")
    @Results({
            @Result(property = "replays", column = "temp_id", many = @Many(select = "com.shanzhu.oe.mapper" +
                    ".ReplayMapper.findAllById"))
    })
    IPage<Message> findAll(Page page);

    /**
     * 通过id查询留言
     *
     * @param id 留言id
     * @return 留言内容
     */
    @Select("select id,title,content,time from message where id = #{id}")
    @Results({
            @Result(property = "replays", column = "id", many = @Many(select = "com.shanzhu.oe.mapper.ReplayMapper" +
                    ".findAllById"))
    })
    Message findById(Integer id);

    /**
     * 删除留言
     *
     * @param id 留言id
     * @return 删除成功数量
     */
    @Delete("delete from message where id = #{id}")
    Integer delete(Integer id);

    /**
     * 更新留言
     *
     * @param message 留言信息
     * @return 结果
     */
    @Update("update message set title = #{title}, content = #{content}, time = #{time} where " +
            "id = #{id}")
    Integer update(Message message);

    /**
     * 添加留言
     *
     * @param message 留言信息
     * @return 结果
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into message(title, content, time) values(#{title},#{content},#{time})")
    int add(Message message);
}
