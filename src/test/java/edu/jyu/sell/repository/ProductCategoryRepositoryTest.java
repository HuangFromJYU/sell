package edu.jyu.sell.repository;

import edu.jyu.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Test
    public void findOneTest(){
        ProductCategory result = categoryRepository.findOne(1);
        Assert.assertNotNull(result);
    }

    @Test
    public  void  saveTest(){
        ProductCategory category = new ProductCategory("食品",3);
        ProductCategory result = categoryRepository.save(category);
        System.out.println(result);
    }

    @Test
    public  void findByCategoryTypeInTest(){
        List<Integer> types = Arrays.asList(2, 3);
        List<ProductCategory> result = categoryRepository.findByCategoryTypeIn(types);
        Assert.assertNotEquals(0,result.size());
    }
}