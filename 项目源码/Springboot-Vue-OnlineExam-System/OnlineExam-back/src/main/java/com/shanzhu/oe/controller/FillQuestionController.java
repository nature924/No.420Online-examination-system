package com.shanzhu.oe.controller;

import com.shanzhu.oe.common.R;
import com.shanzhu.oe.entity.FillQuestion;
import com.shanzhu.oe.service.FillQuestionService;
import com.shanzhu.oe.util.ApiResultHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 填空题 控制层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@RestController
@RequiredArgsConstructor
public class FillQuestionController {

    private final FillQuestionService fillQuestionService;

    /**
     * 添加填空题
     *
     * @param fillQuestion 填空题内容
     * @return 结果
     */
    @PostMapping("/fillQuestion")
    public R add(@RequestBody FillQuestion fillQuestion) {
        int res = fillQuestionService.add(fillQuestion);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200, "添加成功", res);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", res);
    }

    /**
     * 查询最后一条填空题
     *
     * @return 最后一条填空题
     */
    @GetMapping("/fillQuestionId")
    public R<FillQuestion> findOnlyQuestionId() {
        FillQuestion res = fillQuestionService.findOnlyQuestionId();
        return ApiResultHandler.buildApiResult(200, "查询成功", res);
    }

    /**
     * 编辑填空题
     *
     * @param fillQuestion 填空题内容
     * @return 结果
     */
    @PostMapping("/editFillQuestion")
    public R edit(@RequestBody FillQuestion fillQuestion) {
        int res = fillQuestionService.edit(fillQuestion);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200, "修改成功", res);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", res);
    }
}
