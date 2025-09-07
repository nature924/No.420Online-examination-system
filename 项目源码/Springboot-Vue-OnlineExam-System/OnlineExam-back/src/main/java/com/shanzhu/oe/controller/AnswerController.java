package com.shanzhu.oe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.common.R;
import com.shanzhu.oe.service.AnswerService;
import com.shanzhu.oe.util.ApiResultHandler;
import com.shanzhu.oe.vo.AnswerVO;
import com.shanzhu.oe.vo.QuestionVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * 题库 控制层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@RestController
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    /**
     * 查询题库 分页
     *
     * @param page 分页页数
     * @param size 分页大小
     * @param subject 学科
     * @param section 章节
     * @param question 问题
     * @return 题目
     */
    @GetMapping("/answers/{page}/{size}/{subject}/{section}/{question}")
    public R<IPage<AnswerVO> > findAllQuestion(
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size,
            @PathVariable("subject") String subject,
            @PathVariable("section") String section,
            @PathVariable("question") String question
    ){
       IPage<AnswerVO> answerVOIPage = answerService.findAll(new Page<>(page,size), subject, section, question);
       return ApiResultHandler.buildApiResult(200,"查询所有题库", answerVOIPage);
    }

    /**
     * 根据类型和id获取题目
     *
     * @param type 类型
     * @param questionId 题目id
     * @return 题目信息
     */
    @GetMapping("/answers/{type}/{questionId}")
    public R<QuestionVO> findByIdAndType(
            @PathVariable("type") String type,
            @PathVariable("questionId") Long questionId
    ) {
        QuestionVO questionVO = answerService.findByIdAndType(type, questionId);
        return ApiResultHandler.buildApiResult(200, "查询题目", questionVO);
    }

}
