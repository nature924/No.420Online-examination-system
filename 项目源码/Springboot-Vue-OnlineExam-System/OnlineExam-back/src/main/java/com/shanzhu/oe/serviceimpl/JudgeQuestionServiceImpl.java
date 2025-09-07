package com.shanzhu.oe.serviceimpl;

import com.shanzhu.oe.entity.JudgeQuestion;
import com.shanzhu.oe.mapper.JudgeQuestionMapper;
import com.shanzhu.oe.service.JudgeQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 判断题 服务层实现类
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Service
@RequiredArgsConstructor
public class JudgeQuestionServiceImpl implements JudgeQuestionService {

    private final JudgeQuestionMapper judgeQuestionMapper;

    /**
     * 通过试卷id查询问题
     *
     * @param paperId 试卷id
     * @return 问题
     */
    @Override
    public List<JudgeQuestion> findByIdAndType(Integer paperId) {
        return judgeQuestionMapper.findByIdAndType(paperId);
    }

    /**
     * 查询最后一个判断题id
     *
     * @return 最后一个判断题
     */
    @Override
    public JudgeQuestion findOnlyQuestionId() {
        return judgeQuestionMapper.findOnlyQuestionId();
    }

    /**
     * 添加判断题
     *
     * @param judgeQuestion 判断题信息
     * @return 结果
     */
    @Override
    public Integer add(JudgeQuestion judgeQuestion) {
        return judgeQuestionMapper.add(judgeQuestion);
    }

    /**
     *
     * 通过学科查询
     * @param subject 学科
     * @param pageNo 分页数
     * @return 题目id
     */
    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return judgeQuestionMapper.findBySubject(subject,pageNo);
    }

    /**
     * 编辑判断题
     *
     * @param judgeQuestion 判断题
     * @return 结果
     */
    @Override
    public Integer edit(JudgeQuestion judgeQuestion) {
        return judgeQuestionMapper.edit(judgeQuestion);
    }
}
