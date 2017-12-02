package edu.jyu.sell.service;

import edu.jyu.sell.entity.ProductCategory;

import java.util.List;


public interface ProductCategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> types);

    ProductCategory save(ProductCategory category);
}
