package edu.jyu.sell.repository;

import edu.jyu.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    /**
     * 根据商品的状态查询商品信息
     * @param productStatus 商品状态
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
