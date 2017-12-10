package edu.jyu.sell.service.impl;

import edu.jyu.sell.dto.OrderDTO;
import edu.jyu.sell.entity.OrderDetail;
import edu.jyu.sell.enums.OrderStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason
 * @create 2017-12-09 11:53
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("黄药师");
        orderDTO.setBuyerAddress("JYU");
        orderDTO.setBuyerPhone("13421027888");
        orderDTO.setBuyerOpenid("119119");

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123458");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123459");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO result = orderService.findOne("1512792099616104532");
        log.info("【查询单个订单】 result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> result = orderService.findList("119119", request);
        Assert.assertNotEquals(0,result.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1512792099616104532");
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals( OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1512792099616104532");
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals( OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
    }

}