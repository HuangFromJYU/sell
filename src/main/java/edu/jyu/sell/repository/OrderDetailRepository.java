package edu.jyu.sell.repository;

import edu.jyu.sell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Jason
 * @create 2017-12-06 20:39
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    /**
     * 根据订单id查找订单明细
     *
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
