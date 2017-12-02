package edu.jyu.sell.repository;

import edu.jyu.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品类目数据库访问类
 *
 * @author Jason
 * @create 2017-12-02 11:39
 **/
public interface ProductCategoryRepository extends  JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> types);
}
