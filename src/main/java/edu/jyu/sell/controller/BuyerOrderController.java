package edu.jyu.sell.controller;

import edu.jyu.sell.converter.OrderForm2OrderDTO;
import edu.jyu.sell.dto.OrderDTO;
import edu.jyu.sell.entity.OrderDetail;
import edu.jyu.sell.enums.ResultEnum;
import edu.jyu.sell.exception.SellException;
import edu.jyu.sell.form.OrderForm;
import edu.jyu.sell.service.OrderService;
import edu.jyu.sell.util.ResultVOUtil;
import edu.jyu.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 买家订单
 *
 * @author Jason
 * @create 2017-12-10 21:37
 **/
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.error("【创建订单】 参数不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR,bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();
        if(CollectionUtils.isEmpty(orderDetailList)){
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());
        return ResultVOUtil.success(map);

    }
}
