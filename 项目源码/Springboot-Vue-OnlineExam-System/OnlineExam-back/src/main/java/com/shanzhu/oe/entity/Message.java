package com.shanzhu.oe.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * 留言
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Data
public class Message {

    /**
     * id主键
     */
    private Integer id;

    /**
     * 解决id为null创建的一个临时id
     */
    private Integer temp_id;

    /**
     * 标题
     */
    private String title;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 留言时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date time;

    /**
     * 一对多关系，评论信息
     */
    List<Replay> replays;

}