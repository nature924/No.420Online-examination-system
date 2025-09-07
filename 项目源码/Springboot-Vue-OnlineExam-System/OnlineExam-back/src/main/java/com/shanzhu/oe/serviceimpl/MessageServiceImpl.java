package com.shanzhu.oe.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.oe.entity.Message;
import com.shanzhu.oe.mapper.MessageMapper;
import com.shanzhu.oe.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * 留言 控制层实现类
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageMapper messageMapper;

    /**
     * 留言查询 分页
     *
     * @param page 分页内容
     * @return 留言数据
     */
    @Override
    public IPage<Message> findPage(Page page) {
        return messageMapper.findAll(page);
    }

    /**
     * 通过id查询留言
     *
     * @param id 留言id
     * @return 留言内容
     */
    @Override
    public Message findById(Integer id) {
        return messageMapper.findById(id);
    }

    /**
     * 删除留言
     *
     * @param id 留言id
     * @return 删除成功数量
     */
    @Override
    public Integer delete(Integer id) {
        return messageMapper.delete(id);
    }

    /**
     * 更新留言
     *
     * @param message 留言信息
     * @return 结果
     */
    @Override
    public Integer update(Message message) {
        return messageMapper.update(message);
    }

    /**
     * 添加留言
     *
     * @param message 留言信息
     * @return 结果
     */
    @Override
    public Integer add(Message message) {
        return messageMapper.add(message);
    }
}
