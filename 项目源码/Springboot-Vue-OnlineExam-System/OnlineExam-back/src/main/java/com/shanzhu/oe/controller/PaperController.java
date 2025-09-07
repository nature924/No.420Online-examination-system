package com.shanzhu.oe.controller;

import com.shanzhu.oe.common.R;
import com.shanzhu.oe.entity.FillQuestion;
import com.shanzhu.oe.entity.JudgeQuestion;
import com.shanzhu.oe.entity.MultiQuestion;
import com.shanzhu.oe.entity.PaperManage;
import com.shanzhu.oe.serviceimpl.FillQuestionServiceImpl;
import com.shanzhu.oe.serviceimpl.JudgeQuestionServiceImpl;
import com.shanzhu.oe.serviceimpl.MultiQuestionServiceImpl;
import com.shanzhu.oe.serviceimpl.PaperServiceImpl;
import com.shanzhu.oe.util.ApiResultHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 试卷 控制层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@RestController
@RequiredArgsConstructor
public class PaperController {

    private final PaperServiceImpl paperService;

    private final JudgeQuestionServiceImpl judgeQuestionService;

    private final MultiQuestionServiceImpl multiQuestionService;

    private final FillQuestionServiceImpl fillQuestionService;

    /**
     * 查询所有试卷
     *
     * @return 试卷
     */
    @GetMapping("/papers")
    public R<List<PaperManage>> findAll() {
        return ApiResultHandler.buildApiResult(200, "请求成功", paperService.findAll());
    }

    /**
     * 通过试卷id 查询试卷
     *
     * @param paperId 试卷id
     * @return 试卷内容
     */
    @GetMapping("/paper/{paperId}")
    public Map<Integer, List<?>> findById(@PathVariable("paperId") Integer paperId) {
        //选择题题库 1
        List<MultiQuestion> multiQuestionRes = multiQuestionService.findByIdAndType(paperId);
        //填空题题库 2
        List<FillQuestion> fillQuestionsRes = fillQuestionService.findByIdAndType(paperId);
        //判断题题库 3
        List<JudgeQuestion> judgeQuestionRes = judgeQuestionService.findByIdAndType(paperId);
        Map<Integer, List<?>> questionMap = new HashMap<>();
        questionMap.put(1, multiQuestionRes);
        questionMap.put(2, fillQuestionsRes);
        questionMap.put(3, judgeQuestionRes);

        return questionMap;
    }

    /**
     * 添加试卷
     *
     * @param paperManage 试卷内容
     * @return 结果
     */
    @PostMapping("/paperManage")
    public R<Integer> add(@RequestBody PaperManage paperManage) {
        int res = paperService.add(paperManage);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200, "添加成功", res);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", res);
    }

    /**
     * 删除试卷中的某条试题
     *
     * @param paperId    试卷id
     * @param type       题目类型。1选择，2填空，3判断
     * @param questionId 题目id
     */
    @GetMapping("/paper/delete/{paperId}/{type}/{questionId}")
    public R delete(
            @PathVariable("paperId") String paperId,
            @PathVariable("type") String type,
            @PathVariable("questionId") String questionId
    ) {
        paperService.delete(paperId, type, questionId);
        return ApiResultHandler.buildApiResult(200, "删除成功", null);
    }
}
