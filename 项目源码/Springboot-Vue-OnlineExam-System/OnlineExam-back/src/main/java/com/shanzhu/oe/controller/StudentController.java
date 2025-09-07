package com.shanzhu.oe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.common.R;
import com.shanzhu.oe.entity.Student;
import com.shanzhu.oe.service.StudentService;
import com.shanzhu.oe.util.ApiResultHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 学生 控制层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    /**
     * 查询学生 分页
     *
     * @param page      分页页数
     * @param size      分页大学
     * @param name      学生姓名
     * @param grade     班级
     * @param tel       电话
     * @param institute 学院
     * @param major     专业
     * @param clazz     班级
     * @return 学生列表
     */
    @GetMapping("/students/{page}/{size}/{name}/{grade}/{tel}/{institute}/{major}/{clazz}")
    public R<IPage<Student>> findAll(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @PathVariable String name,
            @PathVariable String grade,
            @PathVariable String tel,
            @PathVariable String institute,
            @PathVariable String major,
            @PathVariable String clazz
    ) {
        IPage<Student> res = studentService.findAll(
                new Page<>(page, size), name, grade, tel, institute, major, clazz
        );
        return ApiResultHandler.buildApiResult(200, "分页查询所有学生", res);
    }

    /**
     * 通过学生id查询学生
     *
     * @param studentId 学生id
     * @return 学生
     */
    @GetMapping("/student/{studentId}")
    public R<Student> findById(@PathVariable("studentId") Integer studentId) {
        Student res = studentService.findById(studentId);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200, "请求成功", res);
        } else {
            return ApiResultHandler.buildApiResult(404, "查询的用户不存在", null);
        }
    }

    /**
     * 删除学生
     *
     * @param studentId 学生id
     * @return 结果
     */
    @DeleteMapping("/student/{studentId}")
    public R<Integer> deleteById(@PathVariable("studentId") Integer studentId) {
        return ApiResultHandler.buildApiResult(200, "删除成功", studentService.deleteById(studentId));
    }

    /**
     * 更新学生
     *
     * @param student 学生信息
     * @return 结果
     */
    @PutMapping("/student")
    public R update(@RequestBody Student student) {
        int res = studentService.update(student);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200, "更新成功", res);
        }
        return ApiResultHandler.buildApiResult(400, "更新失败", res);
    }

    /**
     * 添加学生
     *
     * @param student 学生信息
     * @return 结果
     */
    @PostMapping("/student")
    public R add(@RequestBody Student student) {
        int res = studentService.add(student);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200, "添加成功", null);
        } else {
            return ApiResultHandler.buildApiResult(400, "添加失败", null);
        }
    }

    /**
     * 更新密码
     *
     * @param student 学生信息
     * @return 结果
     */
    @PutMapping("/studentPWD")
    public R updatePwd(@RequestBody Student student) {
        studentService.updatePwd(student);
        return ApiResultHandler.buildApiResult(200, "密码更新成功", null);
    }
}
