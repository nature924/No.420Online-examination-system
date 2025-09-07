package com.shanzhu.oe.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.Score;
import com.shanzhu.oe.mapper.ScoreMapper;
import com.shanzhu.oe.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分数 服务层实现类
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {

    private final ScoreMapper scoreMapper;

    /**
     * 添加学生成绩
     *
     * @param score 学生成绩
     * @return 考试成绩
     */
    @Override
    public Integer add(Score score) {
        return scoreMapper.add(score);
    }

    /**
     * 查询所有考试成绩
     *
     * @return 考试成绩
     */
    @Override
    public List<Score> findAll() {
        return scoreMapper.findAll();
    }

    /**
     * 查询考试成绩 分页
     *
     * @param page 分页对象
     * @param studentId 学生id
     * @return 考试成绩
     */
    @Override
    public IPage<Score> findById(Page page, Integer studentId) {
        return scoreMapper.findById(page, studentId);
    }

    /**
     * 查询考试成绩 不分页
     *
     * @param studentId 学生id
     * @return 考试成绩
     */
    @Override
    public List<Score> findById(Integer studentId) {
        Page<Score> scorePage = new Page<>(0, 9999);
        return scoreMapper.findById(scorePage, studentId).getRecords();
    }

    /**
     * 通过考试编号 查询学生成绩
     *
     * @param examCode 考试编号
     * @return 考试成绩
     */
    @Override
    public List<Score> findByExamCode(Integer examCode) {
        return scoreMapper.findByExamCode(examCode);
    }
}
