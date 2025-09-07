package com.shanzhu.oe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.common.R;
import com.shanzhu.oe.entity.Teacher;
import com.shanzhu.oe.service.TeacherService;
import com.shanzhu.oe.util.ApiResultHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 教师 控制层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    /**
     * 查询教师 分页
     *
     * @param page 分页页数
     * @param size 分页大小
     * @return 教师列表
     */
    @GetMapping("/teachers/{page}/{size}")
    public R<IPage<Teacher>> findAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Teacher> teacherPage = new Page<>(page,size);
        IPage<Teacher> teacherIPage = teacherService.findAll(teacherPage);

        return ApiResultHandler.buildApiResult(200,"查询所有教师",teacherIPage);
    }

    /**
     * 通过教师id查询
     *
     * @param teacherId 教师id
     * @return 教师
     */
    @GetMapping("/teacher/{teacherId}")
    public R findById(@PathVariable("teacherId") Integer teacherId){
        return ApiResultHandler.success(teacherService.findById(teacherId));
    }

    /**
     * 删除教师
     *
     * @param teacherId 教师id
     * @return 结果
     */
    @DeleteMapping("/teacher/{teacherId}")
    public R deleteById(@PathVariable("teacherId") Integer teacherId){
        return ApiResultHandler.success(teacherService.deleteById(teacherId));
    }

    /**
     * 更新教师
     *
     * @param teacher 教师信息
     * @return 结果
     */
    @PutMapping("/teacher")
    public R update(@RequestBody Teacher teacher){
        return ApiResultHandler.success(teacherService.update(teacher));
    }

    /**
     * 添加教师
     *
     * @param teacher 教师信息
     * @return 结果
     */
    @PostMapping("/teacher")
    public R add(@RequestBody Teacher teacher){
        return ApiResultHandler.success(teacherService.add(teacher));
    }
}
