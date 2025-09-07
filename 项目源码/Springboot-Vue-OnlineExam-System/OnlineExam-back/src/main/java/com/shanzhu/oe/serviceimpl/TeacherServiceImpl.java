package com.shanzhu.oe.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.Teacher;
import com.shanzhu.oe.mapper.TeacherMapper;
import com.shanzhu.oe.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教师 服务层实现类
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;

    /**
     * 查询教师 分页
     *
     * @param page 分页对象
     * @return 教师列表
     */
    @Override
    public IPage<Teacher> findAll(Page<Teacher> page) {
        return teacherMapper.findAll(page);
    }

    @Override
    public List<Teacher> findAll() {
        Page<Teacher> teacherPage = new Page<>(0,9999);
        return teacherMapper.findAll(teacherPage).getRecords();
    }

    /**
     * 通过教师id查询
     *
     * @param teacherId 教师id
     * @return 教师
     */
    @Override
    public Teacher findById(Integer teacherId) {
        return teacherMapper.findById(teacherId);
    }

    /**
     * 删除教师
     *
     * @param teacherId 教师id
     * @return 结果
     */
    @Override
    public Integer deleteById(Integer teacherId) {
        return teacherMapper.deleteById(teacherId);
    }

    /**
     * 更新教师
     *
     * @param teacher 教师信息
     * @return 结果
     */
    @Override
    public Integer update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    /**
     * 添加教师
     *
     * @param teacher 教师信息
     * @return 结果
     */
    @Override
    public Integer add(Teacher teacher) {
        teacher.setRole("1");
        return teacherMapper.add(teacher);
    }
}
