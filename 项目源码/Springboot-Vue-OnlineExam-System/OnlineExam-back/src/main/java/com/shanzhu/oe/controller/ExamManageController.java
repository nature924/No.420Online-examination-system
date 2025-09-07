package com.shanzhu.oe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.common.R;
import com.shanzhu.oe.entity.ExamManage;
import com.shanzhu.oe.service.ExamManageService;
import com.shanzhu.oe.util.ApiResultHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 考试管理 控制层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@RestController
@RequiredArgsConstructor
public class ExamManageController {

    private final ExamManageService examManageService;

    /**
     * 查询所有考试
     *
     * @return 考试列表
     */
    @GetMapping("/exams")
    public R<List<ExamManage>> findAll() {
        return ApiResultHandler.buildApiResult(200, "请求成功！", examManageService.findAll());
    }

    /**
     * 查询考试 分页
     *
     * @param page 分页页数
     * @param size 分页大小
     * @return 考试列表
     */
    @GetMapping("/exams/{page}/{size}")
    public R<IPage<ExamManage>> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return ApiResultHandler.buildApiResult(200, "请求成功！", examManageService.findAll(new Page<>(page, size)));
    }

    /**
     * 根据考试编号查询考试信息
     *
     * @param examCode 考试编号
     * @return 考试信息
     */
    @GetMapping("/exam/{examCode}")
    public R<ExamManage> findById(@PathVariable("examCode") Integer examCode) {
        ExamManage res = examManageService.findById(examCode);
        if (res == null) {
            return ApiResultHandler.buildApiResult(10000, "考试编号不存在", null);
        }
        return ApiResultHandler.buildApiResult(200, "请求成功！", res);
    }

    /**
     * 根据考试编号删除
     *
     * @param examCode 考试编号
     */
    @DeleteMapping("/exam/{examCode}")
    public R deleteById(@PathVariable("examCode") Integer examCode) {
        return ApiResultHandler.buildApiResult(200, "删除成功", examManageService.delete(examCode));
    }

    /**
     * 根据考试编号更新
     *
     * @param examManage 考试信息
     */
    @PutMapping("/exam")
    public R update(@RequestBody ExamManage examManage) {
        return ApiResultHandler.buildApiResult(200, "更新成功", examManageService.update(examManage));
    }

    /**
     * 添加考试信息
     *
     * @param examManage 考试信息
     */
    @PostMapping("/exam")
    public R add(@RequestBody ExamManage examManage) {
        int res = examManageService.add(examManage);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200, "添加成功", res);
        } else {
            return ApiResultHandler.buildApiResult(400, "添加失败", res);
        }
    }

    /**
     * 查询最后一条记录的paperId,返回给前端达到自增效果
     *
     * @return 最后一条记录
     */
    @GetMapping("/examManagePaperId")
    public R<ExamManage> findOnlyPaperId() {
        ExamManage res = examManageService.findOnlyPaperId();
        if (res != null) {
            return ApiResultHandler.buildApiResult(200, "请求成功", res);
        }

        return ApiResultHandler.buildApiResult(400, "请求失败", res);
    }
}
