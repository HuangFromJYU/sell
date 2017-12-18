package edu.jyu.sell.service;

import edu.jyu.sell.dto.OrderDTO;

/**
 * 买家Service
 *
 * @author Jason
 * @create 2017-12-18 21:28
 **/
public interface BuyerService {
    /**
     * 查询一个订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancel(String openid, String orderId);
}
