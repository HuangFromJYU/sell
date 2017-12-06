package edu.jyu.sell.repository;

import edu.jyu.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jason
 * @create 2017-12-06 20:37
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    /**
     * 根据买家openid查询订单
     *
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
