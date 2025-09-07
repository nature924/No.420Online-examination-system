package com.shanzhu.oe.mapper;

import com.shanzhu.oe.entity.FillQuestion;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 填空题 持久层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Mapper
public interface FillQuestionMapper {

    /**
     * 通过试卷id查询问题
     *
     * @param paperId 试卷id
     * @return 问题
     */
    @Select("select * from fill_question where questionId in (select questionId from paper_manage where questionType " +
            "= 2 and paperId = #{paperId})")
    List<FillQuestion> findByIdAndType(Integer paperId);

    /**
     * 查询最后一条填空题
     *
     * @return 最后一条填空题
     */
    @Select("select questionId from fill_question order by questionId desc limit 1")
    FillQuestion findOnlyQuestionId();

    /**
     * 添加填空题
     *
     * @param fillQuestion 填空题内容
     * @return 结果
     */
    @Options(useGeneratedKeys = true, keyProperty = "questionId")
    @Insert("insert into fill_question(subject,question,answer,analysis,level,section) values " +
            "(#{subject},#{question},#{answer},#{analysis},#{level},#{section})")
    Integer add(FillQuestion fillQuestion);

    /**
     * 通过学科查询
     *
     * @param subject 学科查询
     * @param pageNo 分页数
     * @return 题目
     */
    @Select("select questionId from fill_question where subject = #{subject} order by rand() desc limit #{pageNo}")
    List<Integer> findBySubject(@Param("subject") String subject, @Param("pageNo") Integer pageNo);

    /**
     * 编辑填空题
     *
     * @param fillQuestion 填空题内容
     * @return 结果
     */
    @Update("update fill_question set section = #{section}, question = #{question}, answer = #{answer}, level = " +
            "#{level}, analysis = #{analysis} where questionId = #{questionId}")
    Integer edit(FillQuestion fillQuestion);
}
