package edu.jyu.sell.converter;

import edu.jyu.sell.dto.OrderDTO;
import edu.jyu.sell.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderMaster转成OrderDTO工具类
 *
 * @author Jason
 * @create 2017-12-10 20:11
 **/
public class OrderMaster2OrderDTOConverter {
    /**
     * 将单个OrderMaster对象转换成单个OrderDTO对象
     *
     * @param orderMaster
     * @return
     */
    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    /**
     * 将多个OrderMaster对象转换成多个OrderDTO对象
     *
     * @param orderMasterList
     * @return
     */
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList());
    }
}
