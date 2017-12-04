package edu.jyu.sell.service.impl;

import edu.jyu.sell.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl service;

    @Test
    public void findOne() throws Exception {
        ProductInfo result = service.findOne("123456");
        Assert.assertNotNull(result);
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> result = service.findUpAll();
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> result = service.findAll(request);
        System.out.println(result.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123459");
        productInfo.setProductName("皮蛋");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好香的呢");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result = service.save(productInfo);
        //TODO 记得加事务~
        //int i = 1/0;
        Assert.assertNotNull(result);
    }

}