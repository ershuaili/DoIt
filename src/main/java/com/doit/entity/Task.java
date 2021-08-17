package com.doit.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * (Task)实体类
 *
 * @author 李二帅
 * @since 2021-07-31 16:08:44
 */
@Data
public class Task implements Serializable {
    @Serial
    private static final long serialVersionUID = -59079845592060053L;
    /**
     * 任务ID
     */
    private Integer id;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 是否完成
     */
    private Boolean isFinish;
}
