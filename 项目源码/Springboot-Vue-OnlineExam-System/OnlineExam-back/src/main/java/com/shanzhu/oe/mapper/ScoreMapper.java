package com.shanzhu.oe.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.Score;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 分数 持久层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Mapper
public interface ScoreMapper {

    /**
     * 添加学生成绩
     *
     * @param score 学生成绩
     * @return 考试成绩
     */
    @Options(useGeneratedKeys = true, keyProperty = "scoreId")
    @Insert("insert into score(examCode,studentId,subject,ptScore,etScore,score,answerDate) values(#{examCode}," +
            "#{studentId},#{subject},#{ptScore},#{etScore},#{score},#{answerDate})")
    Integer add(Score score);

    /**
     * 查询所有考试成绩
     *
     * @return 考试成绩
     */
    @Select("select scoreId,examCode,studentId,subject,ptScore,etScore,score,answerDate from score order by scoreId " +
            "desc")
    List<Score> findAll();

    /**
     * 查询考试成绩分页
     *
     * @param page      分页对象
     * @param studentId 学生id
     * @return 考试成绩
     */
    @Select("select scoreId,examCode,studentId,subject,ptScore,etScore,score,answerDate from score where studentId = " +
            "#{studentId} order by scoreId asc")
    IPage<Score> findById(Page<?> page, @Param("studentId") Integer studentId);

    /**
     * 通过考试编号 查询学生成绩
     *
     * @param examCode 考试编号
     * @return 考试成绩
     */
    @Select("select max(etScore) as etScore from score where examCode = #{examCode} group by studentId")
    List<Score> findByExamCode(Integer examCode);
}
