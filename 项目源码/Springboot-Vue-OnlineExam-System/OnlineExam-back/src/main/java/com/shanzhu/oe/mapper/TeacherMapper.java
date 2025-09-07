package com.shanzhu.oe.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.Teacher;
import org.apache.ibatis.annotations.*;

/**
 * 教师 持久层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Mapper
public interface TeacherMapper {

    /**
     * 查询教师 分页
     *
     * @param page 分页对象
     * @return 教师列表
     */
    @Select("select * from teacher")
    IPage<Teacher> findAll(Page page);

    /**
     * 通过教师id查询
     *
     * @param teacherId 教师id
     * @return 教师
     */
    @Select("select * from teacher where teacherId = #{teacherId}")
    Teacher findById(Integer teacherId);

    /**
     * 删除教师
     *
     * @param teacherId 教师id
     * @return 结果
     */
    @Delete("delete from teacher where teacherId = #{teacherId}")
    Integer deleteById(Integer teacherId);

    /**
     * 更新教师
     *
     * @param teacher 教师信息
     * @return 结果
     */
    @Update("update teacher set teacherName = #{teacherName},sex = #{sex}," +
            "tel = #{tel}, email = #{email},pwd = #{pwd},cardId = #{cardId}," +
            "role = #{role},institute = #{institute},type = #{type} where teacherId = #{teacherId}")
    Integer update(Teacher teacher);

    /**
     * 添加教师
     *
     * @param teacher 教师信息
     * @return 结果
     */
    @Options(useGeneratedKeys = true, keyProperty = "teacherId")
    @Insert("insert into teacher(teacherName,sex,tel,email,pwd,cardId,role,type,institute) " +
            "values(#{teacherName},#{sex},#{tel},#{email},#{pwd},#{cardId},#{role},#{type},#{institute})")
    Integer add(Teacher teacher);
}
