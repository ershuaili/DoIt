package com.doit.utils;

import java.util.Random;

/**
 * <p>描述: [] </p>
 * <p>创建时间: 2021/09/22 上午 11:10 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
public class SaltUtils {
    /**
     * 生成salt的静态方法
     *
     * @param n 获取字符串个数
     * @return 随机盐
     */
    public static String getSalt(int n) {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890!@#$%^&*()".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}