package edu.jyu.sell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品详情
 *
 * @author Jason
 * @create 2017-12-03 16:50
 **/
@Entity
@Data
public class ProductInfo {
    /**
     * 上架状态
     */
    public static Integer PRODUCT_STATUS_UP = 0;
    /**
     * 下架状态
     */
    public static Integer PRODUCT_STATUS_DOWN = 1;

    @Id
    private String productId;

    /**
     * 名字.
     */
    private String productName;

    /**
     * 单价.
     */
    private BigDecimal productPrice;

    /**
     * 库存.
     */
    private Integer productStock;

    /**
     * 描述.
     */
    private String productDescription;

    /**
     * 小图.
     */
    private String productIcon;

    /**
     * 状态, 0正常1下架.
     */
    private Integer productStatus;

    /**
     * 类目编号.
     */
    private Integer categoryType;


}
