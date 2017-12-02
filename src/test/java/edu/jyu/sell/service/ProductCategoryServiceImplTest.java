package edu.jyu.sell.service;

import edu.jyu.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl service;

    @Test
    public void findOne() throws Exception {
        ProductCategory result = service.findOne(1);
        Assert.assertNotNull(result);
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> result = service.findAll();
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<Integer> types = Arrays.asList(2, 3);
        List<ProductCategory> result = service.findByCategoryTypeIn(types);
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    //@Transactional 这个注解在此处的作用是不让测试污染数据库，即新增修改删除等操作都会回滚
    public void saveTest() throws Exception {
        ProductCategory category = new ProductCategory("服饰", 5);
        ProductCategory result = service.save(category);
        Assert.assertNotNull(result);
    }

}