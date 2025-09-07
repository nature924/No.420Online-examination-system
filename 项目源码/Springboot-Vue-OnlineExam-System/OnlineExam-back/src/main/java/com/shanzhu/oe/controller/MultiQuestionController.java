package com.shanzhu.oe.controller;

import com.shanzhu.oe.common.R;
import com.shanzhu.oe.entity.MultiQuestion;
import com.shanzhu.oe.service.MultiQuestionService;
import com.shanzhu.oe.util.ApiResultHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 选择题 控制层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@RestController
@RequiredArgsConstructor
public class MultiQuestionController {

    private final MultiQuestionService multiQuestionService;

    /**
     * 通过id查询选择题
     *
     * @return 选择题
     */
    @GetMapping("/multiQuestionId")
    public R<MultiQuestion> findOnlyQuestion() {
        MultiQuestion res = multiQuestionService.findOnlyQuestionId();
        return ApiResultHandler.buildApiResult(200,"查询成功",res);
    }

    /**
     * 添加选择题
     *
     * @param multiQuestion 选择题信息
     * @return 结果
     */
    @PostMapping("/MultiQuestion")
    public R<Integer> add(@RequestBody MultiQuestion multiQuestion) {
        Integer res = multiQuestionService.add(multiQuestion);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"添加失败",res);
    }

    /**
     * 编辑选择题
     *
     * @param multiQuestion 选择题信息
     * @return 结果
     */
    @PostMapping("/editMultiQuestion")
    public R<Integer> edit(@RequestBody MultiQuestion multiQuestion) {
        Integer res = multiQuestionService.edit(multiQuestion);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"修改成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"修改失败",res);
    }

}
