package edu.jyu.sell.enums;

import lombok.Getter;

/**
 * 订单状态
 *
 * @author Jason
 * @create 2017-12-06 19:39
 **/
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),;
    /**
     * 订单状态码
     */
    private Integer code;
    /**
     * 订单状态码描述
     */
    private String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
