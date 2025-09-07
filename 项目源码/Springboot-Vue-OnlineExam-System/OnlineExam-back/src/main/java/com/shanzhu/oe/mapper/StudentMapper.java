package com.shanzhu.oe.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.Student;
import org.apache.ibatis.annotations.*;

/**
 * 学生 持久层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Mapper
public interface StudentMapper {

    /**
     * 查询学生 分页
     *
     * @param page      分页对象
     * @param name      学生姓名
     * @param grade     班级
     * @param tel       电话
     * @param institute 学院
     * @param major     专业
     * @param clazz     班级
     * @return 学生列表
     */
    @Select("select * from student where " +
            "studentName like concat('%',#{name},'%') " +
            "and grade like concat('%',#{grade},'%') " +
            "and tel like concat('%',#{tel},'%') " +
            "and major like concat('%',#{major},'%') " +
            "and institute like concat('%',#{institute},'%') " +
            "and clazz like concat('%',#{clazz},'%')")
    IPage<Student> findAll(Page page, @Param("name") String name, @Param("grade") String grade,
                           @Param("tel") String tel,  @Param("institute") String institute,
                           @Param("major")String major, @Param("clazz") String clazz);

    /**
     * 通过学生id查询学生
     *
     * @param studentId 学生id
     * @return 学生
     */
    @Select("select * from student where studentId = #{studentId}")
    Student findById(Integer studentId);

    /**
     * 删除学生
     *
     * @param studentId 学生id
     * @return 结果
     */
    @Delete("delete from student where studentId = #{studentId}")
    Integer deleteById(Integer studentId);

    /**
     * 更新学生
     *
     * @param student 学生信息
     * @return 结果
     */
    @Update("update student set studentName = #{studentName},grade = #{grade},major = #{major},clazz = #{clazz}," +
            "institute = #{institute},tel = #{tel},email = #{email},pwd = #{pwd},cardId = #{cardId},sex = #{sex},role = #{role} " +
            "where studentId = #{studentId}")
    Integer update(Student student);

    /**
     * 添加学生
     *
     * @param student 学生信息
     * @return 结果
     */
    @Options(useGeneratedKeys = true,keyProperty = "studentId")
    @Insert("insert into student(studentName,grade,major,clazz,institute,tel,email,pwd,cardId,sex,role) values " +
            "(#{studentName},#{grade},#{major},#{clazz},#{institute},#{tel},#{email},#{pwd},#{cardId},#{sex},#{role})")
    Integer add(Student student);

    /**
     * 更新密码
     *
     * @param student 学生信息
     * @return 结果
     */
    @Update("update student set pwd = #{pwd} where studentId = #{studentId}")
    Integer updatePwd(Student student);
}
