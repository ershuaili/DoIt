package com.doit.entity;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * (Step)实体类
 *
 * @author 李二帅
 * @since 2021-07-31 16:08:43
 */
@Data
public class Step implements Serializable {
    @Serial
    private static final long serialVersionUID = 566015801211211533L;
    /**
     * 步骤id
     */
    private Integer id;
    /**
     * 任务id
     */
    private Integer taskId;
    /**
     * 步骤具体内容
     */
    private String content;
    /**
     * 步骤是否完成
     */
    private Boolean isFinish;
    /**
     * 任务步骤
     */
    private Task task;
}
