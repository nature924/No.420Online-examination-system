package com.shanzhu.oe.serviceimpl;

import com.shanzhu.oe.entity.FillQuestion;
import com.shanzhu.oe.entity.JudgeQuestion;
import com.shanzhu.oe.entity.MultiQuestion;
import com.shanzhu.oe.entity.PaperManage;
import com.shanzhu.oe.mapper.PaperMapper;
import com.shanzhu.oe.service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 试卷 服务层实现类
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Service
@RequiredArgsConstructor
public class PaperServiceImpl implements PaperService {

    private final PaperMapper paperMapper;

    private final JudgeQuestionServiceImpl judgeQuestionService;

    private final MultiQuestionServiceImpl multiQuestionService;

    private final FillQuestionServiceImpl fillQuestionService;

    /**
     * 查询所有试卷
     *
     * @return 试卷
     */
    @Override
    public List<PaperManage> findAll() {
        return paperMapper.findAll();
    }

    /**
     * 添加试卷
     *
     * @param paperManage 试卷信息
     * @return 结果
     */
    @Override
    public Integer add(PaperManage paperManage) {
        return paperMapper.add(paperManage);
    }

    /**
     * 获取试卷总分
     *
     * @param paperId 试卷id
     * @return 分数
     */
    @Override
    public Integer getMaxScore(Integer paperId) {

        List<MultiQuestion> multiQuestionRes = multiQuestionService.findByIdAndType(paperId);   //选择题题库 1
        List<FillQuestion> fillQuestionsRes = fillQuestionService.findByIdAndType(paperId);     //填空题题库 2
        List<JudgeQuestion> judgeQuestionRes = judgeQuestionService.findByIdAndType(paperId);   //判断题题库 3
        return 2 * (multiQuestionRes.size() + fillQuestionsRes.size() + judgeQuestionRes.size());
    }

    /**
     * 删除试卷中的某条试题
     *
     * @param paperId    试卷id
     * @param type       题目类型。1选择，2填空，3判断
     * @param questionId 题目id
     */
    @Override
    public void delete(String paperId, String type, String questionId) {
        paperMapper.delete(paperId, type, questionId);
    }

}
