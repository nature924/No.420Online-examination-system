package com.shanzhu.oe.mapper;

import com.shanzhu.oe.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 管理员 持久层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Mapper
public interface AdminMapper {

    /**
     * 查询所有管理员
     *
     * @return 管理员
     */
    @Select("select adminName,sex,tel,email,cardId,role from admin")
    List<Admin> findAll();

    /**
     * 通过管理员id查询
     *
     * @param adminId 管理员id
     * @return 管理员
     */
    @Select("select adminId,adminName,sex,tel,email,cardId,role,pwd from admin where adminId = #{adminId}")
    Admin findById(Integer adminId);

    /**
     * 通过管理员id删除
     *
     * @param adminId 管理员id
     * @return 结果
     */
    @Delete("delete from admin where adminId = #{adminId}")
    Integer deleteById(Integer adminId);

    /**
     * 更新管理员
     *
     * @param admin 管理员信息
     * @return 结果
     */
    @Update("update admin set adminName = #{adminName},sex = #{sex}," +
            "tel = #{tel}, email = #{email},pwd = #{pwd},cardId = #{cardId},role = #{role} where adminId = #{adminId}")
    Integer update(Admin admin);

    /**
     * 添加管理员
     *
     * @param admin 管理员信息
     * @return 结果
     */
    @Options(useGeneratedKeys = true, keyProperty = "adminId")
    @Insert("insert into admin(adminName,sex,tel,email,pwd,cardId,role) " +
            "values(#{adminName},#{sex},#{tel},#{email},#{pwd},#{cardId},#{role})")
    Integer add(Admin admin);
}
