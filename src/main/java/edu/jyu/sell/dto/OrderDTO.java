package edu.jyu.sell.dto;

import edu.jyu.sell.entity.OrderDetail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单DTO，视图层与服务层之间的数据传输对象
 * @author Jason
 * @create 2017-12-09 10:23
 **/
public class OrderDTO {
    /**
     * 订单id.
     */
    private String orderId;

    /**
     * 买家名字.
     */
    private String buyerName;

    /**
     * 买家手机号.
     */
    private String buyerPhone;

    /**
     * 买家地址.
     */
    private String buyerAddress;

    /**
     * 买家微信Openid.
     */
    private String buyerOpenid;

    /**
     * 订单总金额.
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态.
     */
    private Integer orderStatus;

    /**
     * 支付状态.
     */
    private Integer payStatus;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;
    /**
     * 订单明细.
     */
    List<OrderDetail> orderDetailList;
}
