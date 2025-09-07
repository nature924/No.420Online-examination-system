package com.shanzhu.oe.controller;

import com.shanzhu.oe.common.R;
import com.shanzhu.oe.entity.JudgeQuestion;
import com.shanzhu.oe.service.JudgeQuestionService;
import com.shanzhu.oe.util.ApiResultHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 判断题 控制层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@RestController
@RequiredArgsConstructor
public class JudgeQuestionController {

    private final JudgeQuestionService judgeQuestionService;

    /**
     * 添加判断题
     *
     * @param judgeQuestion 判断题信息
     * @return 结果
     */
    @PostMapping("/judgeQuestion")
    public R add(@RequestBody JudgeQuestion judgeQuestion) {
        int res = judgeQuestionService.add(judgeQuestion);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"添加失败",res);
    }

    /**
     * 查询最后一个判断题id
     *
     * @return 最后一个判断题
     */
    @GetMapping("/judgeQuestionId")
    public R<JudgeQuestion> findOnlyQuestionId() {
        JudgeQuestion res = judgeQuestionService.findOnlyQuestionId();
        return  ApiResultHandler.buildApiResult(200,"查询成功",res);
    }

    /**
     * 编辑判断题
     *
     * @param judgeQuestion 判断题
     * @return 结果
     */
    @PostMapping("/editJudgeQuestion")
    public R edit(@RequestBody JudgeQuestion judgeQuestion) {
        int res = judgeQuestionService.edit(judgeQuestion);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"修改成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"修改失败",res);
    }
}
