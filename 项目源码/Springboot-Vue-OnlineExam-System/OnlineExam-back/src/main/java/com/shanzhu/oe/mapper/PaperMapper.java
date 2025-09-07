package com.shanzhu.oe.mapper;

import com.shanzhu.oe.entity.PaperManage;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 试卷 持久层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Mapper
public interface PaperMapper {

    /**
     * 查询所有试卷
     *
     * @return 试卷
     */
    @Select("select paperId, questionType,questionId from paper_manage")
    List<PaperManage> findAll();

    /**
     * 添加试卷
     *
     * @param paperManage 试卷信息
     * @return 结果
     */
    @Insert("insert into paper_manage(paperId,questionType,questionId) values " +
            "(#{paperId},#{questionType},#{questionId})")
    Integer add(PaperManage paperManage);

    /**
     * 删除试卷中的某条试题
     *
     * @param paperId    试卷id
     * @param type       题目类型。1选择，2填空，3判断
     * @param questionId 题目id
     */
    @Delete("delete from paper_manage where paperId = #{paperId} and questionType = #{type} and questionId = " +
            "#{questionId}")
    void delete(@Param("paperId") String paperId, @Param("type") String type, @Param("questionId") String questionId);
}
