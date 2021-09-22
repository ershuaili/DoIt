package com.doit.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author 李二帅
 * @since 2021-09-22 21:15:18
 */
@Data
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 431281599743305477L;
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户密码
     */
    private String password;
}
