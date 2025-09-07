package com.shanzhu.oe.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.mapper.AnswerMapper;
import com.shanzhu.oe.service.AnswerService;
import com.shanzhu.oe.vo.AnswerVO;
import com.shanzhu.oe.vo.QuestionVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 题库 服务层实现类
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerMapper answerMapper;

    /**
     * 查询题库 分页
     *
     * @param page 分页对象
     * @param subject 学科
     * @param section 章节
     * @param question 问题
     * @return 题目
     */
    @Override
    public IPage<AnswerVO> findAll(Page<AnswerVO> page, String subject, String section, String question) {
        subject = (subject.equals("@") ? "" : subject);
        section = (section.equals("@") ? "" : section);
        question = (question.equals("@") ? "" : question);
        return answerMapper.findAll(page, subject, section, question);
    }

    /**
     * 根据类型和id获取题目
     *
     * @param type 类型
     * @param questionId 题目id
     * @return 题目信息
     */
    @Override
    public QuestionVO findByIdAndType(String type, Long questionId) {
        QuestionVO questionVO = new QuestionVO();
        questionVO.setType(type);
        switch (type) {
            case "选择题":
                questionVO.setMultiQuestion(answerMapper.findMultiQuestionById(questionId));
                break;
            case "判断题":
                questionVO.setJudgeQuestion(answerMapper.findJudgeQuestionById(questionId));
                break;
            case "填空题":
                questionVO.setFillQuestion(answerMapper.findFillQuestionById(questionId));
                break;
        }
        return questionVO;
    }
}
