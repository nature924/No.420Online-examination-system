package com.shanzhu.oe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.common.R;
import com.shanzhu.oe.entity.Score;
import com.shanzhu.oe.service.ScoreService;
import com.shanzhu.oe.util.ApiResultHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 考试成绩 控制层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@RestController
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    /**
     * 查询所有考试成绩
     *
     * @return 考试成绩
     */
    @GetMapping("/scores")
    public R<List<Score>> findAll() {
        List<Score> res = scoreService.findAll();
        return ApiResultHandler.buildApiResult(200, "查询所有学生成绩", res);
    }

    /**
     * 查询考试成绩 分页
     *
     * @param page      分页页数
     * @param size      分页大学
     * @param studentId 学生id
     * @return 考试成绩
     */
    @GetMapping("/score/{page}/{size}/{studentId}")
    public R<Page<Score>> findById(
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size,
            @PathVariable("studentId") Integer studentId
    ) {
        IPage<Score> res = scoreService.findById(new Page<>(page, size), studentId);
        return ApiResultHandler.buildApiResult(200, "根据ID查询成绩", res);
    }

    /**
     * 查询考试成绩 不分页
     *
     * @param studentId 学生id
     * @return 考试成绩
     */
    @GetMapping("/score/{studentId}")
    public R<List<Score>> findById(@PathVariable("studentId") Integer studentId) {
        List<Score> res = scoreService.findById(studentId);
        if (!res.isEmpty()) {
            return ApiResultHandler.buildApiResult(200, "根据ID查询成绩", res);
        } else {
            return ApiResultHandler.buildApiResult(400, "ID不存在", res);
        }
    }

    /**
     * 添加学生成绩
     *
     * @param score 学生成绩
     * @return 考试成绩
     */
    @PostMapping("/score")
    public R add(@RequestBody Score score) {
        int res = scoreService.add(score);
        if (res == 0) {
            return ApiResultHandler.buildApiResult(400, "成绩添加失败", res);
        } else {
            return ApiResultHandler.buildApiResult(200, "成绩添加成功", res);
        }
    }

    /**
     * 通过考试编号 查询学生成绩
     *
     * @param examCode 考试编号
     * @return 考试成绩
     */
    @GetMapping("/scores/{examCode}")
    public R<List<Score>> findByExamCode(@PathVariable("examCode") Integer examCode) {
        List<Score> scores = scoreService.findByExamCode(examCode);
        return ApiResultHandler.buildApiResult(200, "查询成功", scores);
    }
}
