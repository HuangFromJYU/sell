package edu.jyu.sell.service.impl;

import edu.jyu.sell.entity.ProductCategory;
import edu.jyu.sell.repository.ProductCategoryRepository;
import edu.jyu.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品类目业务类
 *
 * @author Jason
 * @create 2017-12-02 12:13
 **/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> types) {
        return repository.findByCategoryTypeIn(types);
    }

    @Override
    public ProductCategory save(ProductCategory category) {
        return repository.save(category);
    }
}
