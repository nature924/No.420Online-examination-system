package com.shanzhu.oe.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.ExamManage;
import org.apache.ibatis.annotations.*;

/**
 * 考试管理 持久层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Mapper
public interface ExamManageMapper {

    @Select("select * from exam_manage")
    IPage<ExamManage> findAll(Page page);

    /**
     * 通过考试编号查询
     *
     * @param examCode 考试编号
     * @return 考试信息
     */
    @Select("select * from exam_manage where examCode = #{examCode}")
    ExamManage findById(Integer examCode);

    /**
     * 根据考试编号删除
     *
     * @param examCode 考试编号
     */
    @Delete("delete from exam_manage where examCode = #{examCode}")
    int delete(Integer examCode);

    @Update("update exam_manage set description = #{description},source = #{source},paperId = #{paperId}," +
            "examDate = #{examDate},totalTime = #{totalTime},grade = #{grade},term = #{term}," +
            "major = #{major},institute = #{institute},totalScore = #{totalScore}," +
            "type = #{type},tips = #{tips} where examCode = #{examCode}")
    int update(ExamManage exammanage);

    @Options(useGeneratedKeys = true, keyProperty = "examCode")
    @Insert("insert into exam_manage(description,source,paperId,examDate,totalTime,grade,term,major,institute," +
            "totalScore,type,tips)" +
            " values(#{description},#{source},#{paperId},#{examDate},#{totalTime},#{grade},#{term},#{major}," +
            "#{institute},#{totalScore},#{type},#{tips})")
    int add(ExamManage exammanage);

    /**
     * 查询最后一条记录的paperId,返回给前端达到自增效果
     *
     * @return paperId
     */
    @Select("select paperId from exam_manage order by paperId desc limit 1")
    ExamManage findOnlyPaperId();
}
