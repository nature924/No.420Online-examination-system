package com.shanzhu.oe.mapper;

import com.shanzhu.oe.entity.MultiQuestion;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 选择题 持久层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Mapper
public interface MultiQuestionMapper {

    /**
     * 通过试卷id 查询试卷
     *
     * @param paperId 试卷id
     * @return 问题
     */
    @Select("select * from multi_question where questionId in (select questionId from paper_manage where questionType" +
            " = 1 and paperId = #{paperId})")
    List<MultiQuestion> findByIdAndType(Integer paperId);

    /**
     * 通过id查询选择题
     *
     * @return 选择题
     */
    @Select("select questionId from multi_question order by questionId desc limit 1")
    MultiQuestion findOnlyQuestionId();

    /**
     * 添加选择题
     *
     * @param multiQuestion 选择题信息
     * @return 结果
     */
    @Options(useGeneratedKeys = true, keyProperty = "questionId")
    @Insert("insert into multi_question(subject,question,answerA,answerB,answerC,answerD,rightAnswer,analysis," +
            "section,level) " +
            "values(#{subject},#{question},#{answerA},#{answerB},#{answerC},#{answerD},#{rightAnswer},#{analysis}," +
            "#{section},#{level})")
    Integer add(MultiQuestion multiQuestion);

    /**
     * 通过学科查询
     *
     * @param subject 学科
     * @param pageNo 分页数
     * @return 题目id
     */
    @Select("select questionId from multi_question  where subject =#{subject} order by rand() desc limit #{pageNo}")
    List<Integer> findBySubject(@Param("subject") String subject, @Param("pageNo") Integer pageNo);

    /**
     * 编辑选择题
     *
     * @param multiQuestion 选择题信息
     * @return 结果
     */
    @Update("update multi_question set subject = #{subject}, question = #{question}, answerA = #{answerA}, answerB = " +
            "#{answerB}, answerC = #{answerC}, answerD = #{answerD}, rightAnswer = #{rightAnswer}, analysis = " +
            "#{analysis}, section = #{section}, level = #{level} where questionId = #{questionId}")
    int edit(MultiQuestion multiQuestion);
}
