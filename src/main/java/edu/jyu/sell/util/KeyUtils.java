package edu.jyu.sell.util;

import java.util.Random;

/**
 * 键生成工具类
 *
 * @author Jason
 * @create 2017-12-09 10:50
 **/
public class KeyUtils {

    private KeyUtils() {
    }

    /**
     * 生成唯一主键
     *
     * @return
     */
    public static String generateUniqueKey() {
        Random random = new Random();
        //生成6位随机数
        Integer num = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(num);
    }
}
