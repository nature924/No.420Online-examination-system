package com.shanzhu.oe.mapper;

import com.shanzhu.oe.entity.JudgeQuestion;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 判断题 持久层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Mapper
public interface JudgeQuestionMapper {

    /**
     * 通过试卷id查询问题
     *
     * @param paperId 试卷id
     * @return 问题
     */
    @Select("select * from judge_question where questionId in (select questionId from paper_manage where questionType = 3 and paperId = #{paperId})")
    List<JudgeQuestion> findByIdAndType(Integer paperId);

    /**
     * 查询最后一个判断题id
     *
     * @return 最后一个判断题
     */
    @Select("select questionId from judge_question order by questionId desc limit 1")
    JudgeQuestion findOnlyQuestionId();

    /**
     * 添加判断题
     *
     * @param judgeQuestion 判断题信息
     * @return 结果
     */
    @Insert("insert into judge_question(subject,question,answer,analysis,level,section) values " +
            "(#{subject},#{question},#{answer},#{analysis},#{level},#{section})")
    int add(JudgeQuestion judgeQuestion);

    /**
     * 通过学科查询
     *
     * @param subject 学科
     * @param pageNo 分页数
     * @return 题目id
     */
    @Select("select questionId from judge_question  where subject=#{subject}  order by rand() desc limit #{pageNo}")
    List<Integer> findBySubject(@Param("subject") String subject, @Param("pageNo") Integer pageNo);

    /**
     * 编辑判断题
     *
     * @param judgeQuestion 判断题
     * @return 结果
     */
    @Update("update judge_question set subject = #{subject}, question = #{question}, answer = #{answer}, section = #{section}, analysis = #{analysis}, level = #{level} where questionId = #{questionId}")
    int edit(JudgeQuestion judgeQuestion);
}
