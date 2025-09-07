package com.shanzhu.oe.controller;

import com.shanzhu.oe.common.R;
import com.shanzhu.oe.entity.PaperManage;
import com.shanzhu.oe.service.FillQuestionService;
import com.shanzhu.oe.service.JudgeQuestionService;
import com.shanzhu.oe.service.MultiQuestionService;
import com.shanzhu.oe.service.PaperService;
import com.shanzhu.oe.util.ApiResultHandler;
import com.shanzhu.oe.vo.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 组卷 控制层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@RestController
@RequiredArgsConstructor
public class ItemController {

    private final MultiQuestionService multiQuestionService;

    private final FillQuestionService fillQuestionService;

    private final JudgeQuestionService judgeQuestionService;

    private final PaperService paperService;

    /**
     * 组卷
     *
     * @param item 题目模型
     * @return 结果
     */
    @PostMapping("/item")
    public R ItemController(@RequestBody Item item) {
        // 选择题
        Integer changeNumber = item.getChangeNumber();
        // 填空题
        Integer fillNumber = item.getFillNumber();
        // 判断题
        Integer judgeNumber = item.getJudgeNumber();
        //出卷id
        Integer paperId = item.getPaperId();

        // 数据库获取数据
        List<Integer> changeNumbers = multiQuestionService.findBySubject(item.getSubject(), changeNumber);
        List<Integer> fills = fillQuestionService.findBySubject(item.getSubject(), fillNumber);
        List<Integer> judges = judgeQuestionService.findBySubject(item.getSubject(), judgeNumber);

        if (changeNumbers == null || changeNumbers.size() != changeNumber) {
            return ApiResultHandler.buildApiResult(400,
                    "科目【" + item.getSubject() + "】题库【选择题】题目数量不足【" + changeNumber + "】，组卷失败", null);
        }
        if (fills == null || fills.size() != fillNumber) {
            return ApiResultHandler.buildApiResult(400, "科目【" + item.getSubject() + "】题库【填空题】题目数量不足【" + fillNumber +
                    "】，组卷失败", null);
        }
        if (judges == null || judges.size() != judgeNumber) {
            return ApiResultHandler.buildApiResult(400,
                    "科目【" + item.getSubject() + "】题库【判断题】题目数量不足【" + judgeNumber + "】，组卷失败", null);
        }

        // 符合组题条件，执行组题
        // 选择题
        for (Integer number : changeNumbers) {
            PaperManage paperManage = new PaperManage(paperId, 1, number);
            int index = paperService.add(paperManage);
            if (index == 0)
                return ApiResultHandler.buildApiResult(400, "选择题组卷保存失败", null);
        }

        // 填空题
        for (Integer fillNum : fills) {
            PaperManage paperManage = new PaperManage(paperId, 2, fillNum);
            int index = paperService.add(paperManage);
            if (index == 0)
                return ApiResultHandler.buildApiResult(400, "填空题题组卷保存失败", null);
        }
        // 判断题
        for (Integer judge : judges) {
            PaperManage paperManage = new PaperManage(paperId, 3, judge);
            int index = paperService.add(paperManage);
            if (index == 0)
                return ApiResultHandler.buildApiResult(400, "判断题题组卷保存失败", null);
        }

        return ApiResultHandler.buildApiResult(200, "试卷组卷成功", null);
    }
}
