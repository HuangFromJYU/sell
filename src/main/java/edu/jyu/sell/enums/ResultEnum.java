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

    PARAM_ERROR(1,"参数不正确"),

    PRODUCT_NOT_EXIST(10, "商品不存在"),

    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),

    ORDER_NOT_EXIST(12,"订单不存在"),

    ORDERDETAIL_NOT_EXIST(13,"订单明细不存在"),

    ORDER_STATUS_ERROR(14,"订单状态错误"),

    ORDER_UPDATE_FAIL(15,"订单更新失败"),

    ORDER_DETAIL_EMPTY(16,"订单明细为空"),

    ORDER_PAY_STATUS_ERROR(17,"订单支付状态错误"),

    CART_EMPTY(18,"订单支付状态错误"),
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
