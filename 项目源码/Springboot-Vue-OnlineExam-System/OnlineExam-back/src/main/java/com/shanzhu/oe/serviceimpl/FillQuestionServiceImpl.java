package com.shanzhu.oe.serviceimpl;

import com.shanzhu.oe.entity.FillQuestion;
import com.shanzhu.oe.mapper.FillQuestionMapper;
import com.shanzhu.oe.service.FillQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 填空题 服务层实现类
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Service
@RequiredArgsConstructor
public class FillQuestionServiceImpl implements FillQuestionService {

    private final FillQuestionMapper fillQuestionMapper;

    /**
     * 通过试卷id查询问题
     *
     * @param paperId 试卷id
     * @return 问题
     */
    @Override
    public List<FillQuestion> findByIdAndType(Integer paperId) {
        return fillQuestionMapper.findByIdAndType(paperId);
    }

    /**
     * 查询最后一条填空题
     *
     * @return 最后一条填空题
     */
    @Override
    public FillQuestion findOnlyQuestionId() {
        return fillQuestionMapper.findOnlyQuestionId();
    }

    /**
     * 添加填空题
     *
     * @param fillQuestion 填空题内容
     * @return 结果
     */
    @Override
    public Integer add(FillQuestion fillQuestion) {
        return fillQuestionMapper.add(fillQuestion);
    }

    /**
     * 通过学科查询
     *
     * @param subject 学科查询
     * @param pageNo 分页数
     * @return 题目
     */
    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return fillQuestionMapper.findBySubject(subject,pageNo);
    }

    /**
     * 编辑填空题
     *
     * @param fillQuestion 填空题内容
     * @return 结果
     */
    @Override
    public Integer edit(FillQuestion fillQuestion) {
        return fillQuestionMapper.edit(fillQuestion);
    }
}
