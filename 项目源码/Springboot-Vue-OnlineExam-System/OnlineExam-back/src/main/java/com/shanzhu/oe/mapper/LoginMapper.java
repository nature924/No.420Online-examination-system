package com.shanzhu.oe.mapper;

import com.shanzhu.oe.entity.Admin;
import com.shanzhu.oe.entity.Student;
import com.shanzhu.oe.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 用户登录 持久层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Mapper
public interface LoginMapper {

    /**
     * 管理员登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录用户信息
     */
    @Select("select adminId,adminName,sex,tel,email,cardId,role from admin where adminId = #{username} and pwd = " +
            "#{password}")
    Admin adminLogin(@Param("username") Integer username, @Param("password") String password);

    /**
     * 教师登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录用户信息
     */
    @Select("select teacherId,teacherName,institute,sex,tel,email,cardId," +
            "type,role from teacher where teacherId = #{username} and pwd = #{password}")
    Teacher teacherLogin(@Param("username") Integer username, @Param("password") String password);

    /**
     * 学生登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录用户信息
     */
    @Select("select studentId,studentName,grade,major,clazz,institute,tel," +
            "email,cardId,sex,role from student where studentId = #{username} and pwd = #{password}")
    Student studentLogin(@Param("username") Integer username, @Param("password") String password);
}
