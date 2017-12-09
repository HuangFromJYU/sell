package edu.jyu.sell.dto;

import lombok.Data;

/**
 * 购物车
 *
 * @author Jason
 * @create 2017-12-09 11:08
 **/
@Data
public class CartDTO {
    /**
     * 商品Id.
     */
    private String productId;

    /**
     * 数量.
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
