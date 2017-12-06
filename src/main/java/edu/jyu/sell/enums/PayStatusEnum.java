package edu.jyu.sell.enums;

import lombok.Getter;

/**
 * 订单支付状态
 *
 * @author Jason
 * @create 2017-12-06 19:36
 **/
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");
    /**
     * 订单支付状态码
     */
    private Integer code;
    /**
     * 订单支付状态码描述
     */
    private String desc;

    PayStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
