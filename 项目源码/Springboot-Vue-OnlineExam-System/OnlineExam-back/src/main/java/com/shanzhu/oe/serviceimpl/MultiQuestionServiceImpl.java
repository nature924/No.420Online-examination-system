package com.shanzhu.oe.serviceimpl;

import com.shanzhu.oe.entity.MultiQuestion;
import com.shanzhu.oe.mapper.MultiQuestionMapper;
import com.shanzhu.oe.service.MultiQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 选择题 服务层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Service
@RequiredArgsConstructor
public class MultiQuestionServiceImpl implements MultiQuestionService {

    private final MultiQuestionMapper multiQuestionMapper;

    /**
     * 通过试卷id 查询试卷
     *
     * @param paperId 试卷id
     * @return 问题
     */
    @Override
    public List<MultiQuestion> findByIdAndType(Integer paperId) {
        return multiQuestionMapper.findByIdAndType(paperId);
    }

    /**
     * 通过id查询选择题
     *
     * @return 选择题
     */
    @Override
    public MultiQuestion findOnlyQuestionId() {
        return multiQuestionMapper.findOnlyQuestionId();
    }

    /**
     * 添加选择题
     *
     * @param multiQuestion 选择题信息
     * @return 结果
     */
    @Override
    public Integer add(MultiQuestion multiQuestion) {
        return multiQuestionMapper.add(multiQuestion);
    }

    /**
     * 通过学科查询
     *
     * @param subject 学科
     * @param pageNo 分页数
     * @return 题目id
     */
    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return multiQuestionMapper.findBySubject(subject,pageNo);
    }

    /**
     * 编辑选择题
     *
     * @param multiQuestion 选择题信息
     * @return 结果
     */
    @Override
    public Integer edit(MultiQuestion multiQuestion) {
        return multiQuestionMapper.edit(multiQuestion);
    }
}
