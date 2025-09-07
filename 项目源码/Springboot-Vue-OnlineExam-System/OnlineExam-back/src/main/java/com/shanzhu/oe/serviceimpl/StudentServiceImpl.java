package com.shanzhu.oe.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.Student;
import com.shanzhu.oe.mapper.StudentMapper;
import com.shanzhu.oe.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 学生 服务层实现类
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

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
    @Override
    public IPage<Student> findAll(
            Page<Student> page, String name, String grade,
            String tel, String institute, String major, String clazz
    ) {
        name = ("@".equals(name) ? "" : name);
        grade = ("@".equals(grade) ? "" : grade);
        tel = ("@".equals(tel) ? "" : tel);
        institute = ("@".equals(institute) ? "" : institute);
        major = ("@".equals(major) ? "" : major);
        clazz = ("@".equals(clazz) ? "" : clazz);
        return studentMapper.findAll(page, name, grade, tel, institute, major, clazz);
    }

    /**
     * 通过学生id查询学生
     *
     * @param studentId 学生id
     * @return 学生
     */
    @Override
    public Student findById(Integer studentId) {
        return studentMapper.findById(studentId);
    }

    /**
     * 删除学生
     *
     * @param studentId 学生id
     * @return 结果
     */
    @Override
    public Integer deleteById(Integer studentId) {
        return studentMapper.deleteById(studentId);
    }

    /**
     * 更新学生
     *
     * @param student 学生信息
     * @return 结果
     */
    @Override
    public Integer update(Student student) {
        return studentMapper.update(student);
    }

    /**
     * 添加学生
     *
     * @param student 学生信息
     * @return 结果
     */
    @Override
    public Integer add(Student student) {
        return studentMapper.add(student);
    }

    /**
     * 更新密码
     *
     * @param student 学生信息
     * @return 结果
     */
    @Override
    public Integer updatePwd(Student student) {
        return studentMapper.updatePwd(student);
    }
}
