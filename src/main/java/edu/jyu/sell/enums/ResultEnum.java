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

    PRODUCT_NOT_EXIST(10, "商品不存在"),

    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),

    ORDER_NOT_EXIST(12,"订单不存在"),

    ORDERDETAIL_NOT_EXIST(13,"订单明细不存在"),
    ;

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
