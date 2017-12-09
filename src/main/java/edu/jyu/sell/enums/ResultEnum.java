package edu.jyu.sell.enums;

import lombok.Getter;

/**
 * 提示消息码枚举
 *
 * @author Jason
 * @create 2017-12-09 10:36
 **/
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10, "商品不存在");

    /**
     * 消息码
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
