package com.shanzhu.oe.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.ExamManage;
import com.shanzhu.oe.mapper.ExamManageMapper;
import com.shanzhu.oe.service.ExamManageService;
import com.shanzhu.oe.service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 考试管理 服务层实现类
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Service
@RequiredArgsConstructor
public class ExamManageServiceImpl implements ExamManageService {

    private final ExamManageMapper examManageMapper;

    private final PaperService paperService;

    /**
     * 查询所有考试
     *
     * @return 考试列表
     */
    @Override
    public List<ExamManage> findAll() {
        Page<ExamManage> examManage = new Page<>(0, 9999);
        List<ExamManage> examManageList = examManageMapper.findAll(examManage).getRecords();
        setMaxScore(examManageList);
        return examManageList;
    }

    /**
     * 查询考试 分页
     *
     * @param page 分页对象
     * @return 考试列表
     */
    @Override
    public IPage<ExamManage> findAll(Page<ExamManage> page) {
        IPage<ExamManage> iPage = examManageMapper.findAll(page);
        setMaxScore(iPage.getRecords());
        return iPage;
    }

    /**
     * 根据考试编号查询考试信息
     *
     * @param examCode 考试编好
     * @return 考试信息
     */
    @Override
    public ExamManage findById(Integer examCode) {
        ExamManage examManage = examManageMapper.findById(examCode);
        examManage.setTotalScore(paperService.getMaxScore(examManage.getPaperId()));
        return examManage;
    }

    /**
     * 根据考试编号删除
     *
     * @param examCode 考试编号
     */
    @Override
    public Integer delete(Integer examCode) {
        return examManageMapper.delete(examCode);
    }

    /**
     * 更新考试信息
     *
     * @param examManage 考试信息
     */
    @Override
    public Integer update(ExamManage examManage) {
        return examManageMapper.update(examManage);
    }

    /**
     * 添加考试信息
     *
     * @param examManage 考试信息
     */
    @Override
    public Integer add(ExamManage examManage) {
        return examManageMapper.add(examManage);
    }

    /**
     * 查询最后一条记录的paperId,返回给前端达到自增效果
     *
     * @return 最后一条记录
     */
    @Override
    public ExamManage findOnlyPaperId() {
        return examManageMapper.findOnlyPaperId();
    }

    /**
     * 设置最高分
     *
     * @param examManageList
     */
    private void setMaxScore(List<ExamManage> examManageList) {
        for (ExamManage examManage : examManageList) {
            examManage.setTotalScore(paperService.getMaxScore(examManage.getPaperId()));
        }
    }
}
