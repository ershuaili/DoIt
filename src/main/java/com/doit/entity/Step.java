package com.doit.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * (Step)实体类
 *
 * @author 李二帅
 * @since 2021-07-30 23:05:46
 */
@Data
public class Step implements Serializable {
    @Serial
    private static final long serialVersionUID = 736669074601829942L;
    /**
     * 步骤id
     */
    private Integer id;
    /**
     * 步骤具体内容
     */
    private String content;
    /**
     * 步骤是否完成
     */
    private Boolean isFinish;
}
