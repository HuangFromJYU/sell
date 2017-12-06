package edu.jyu.sell.repository;

import edu.jyu.sell.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author Jason
 * @create 2017-12-06 20:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234568");
        orderMaster.setBuyerName("黄药师");
        orderMaster.setBuyerPhone("13421027811");
        orderMaster.setBuyerAddress("嘉应学院");
        orderMaster.setBuyerOpenid("119119");
        orderMaster.setOrderAmount(new BigDecimal(2.58));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        Pageable pageable = new PageRequest(0,2);
        Page<OrderMaster> result = repository.findByBuyerOpenid("119119", pageable);
        Assert.assertNotEquals(0,result.getTotalElements());
    }

}