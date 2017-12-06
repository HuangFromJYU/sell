package edu.jyu.sell;

import lombok.Getter;

/**
 * 商品状态
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "上架"), DOWN(1, "下架");


    /**
     * 商品状态码
     */
    private Integer code;
    /**
     * 商品状态码描述
     */
    private String desc;

    ProductStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
