package edu.jyu.sell.service.impl;

import edu.jyu.sell.dto.CartDTO;
import edu.jyu.sell.dto.OrderDTO;
import edu.jyu.sell.entity.OrderDetail;
import edu.jyu.sell.entity.OrderMaster;
import edu.jyu.sell.entity.ProductInfo;
import edu.jyu.sell.enums.OrderStatusEnum;
import edu.jyu.sell.enums.PayStatusEnum;
import edu.jyu.sell.enums.ResultEnum;
import edu.jyu.sell.exception.SellException;
import edu.jyu.sell.repository.OrderDetailRepository;
import edu.jyu.sell.repository.OrderMasterRepository;
import edu.jyu.sell.repository.ProductInfoRepository;
import edu.jyu.sell.service.OrderService;
import edu.jyu.sell.service.ProductInfoService;
import edu.jyu.sell.util.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单业务类
 *
 * @author Jason
 * @create 2017-12-09 10:30
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private ProductInfoService productInfoService;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        //订单总价
        BigDecimal orderAmount = new BigDecimal(0);
        //订单ID
        String orderId = KeyUtils.generateUniqueKey();

        //1.查询商品
        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();
        for (OrderDetail orderDetail : orderDetailList) {
            ProductInfo productInfo = productInfoRepository.findOne(orderDetail.getProductId());
            //判断商品是否存在
            if (null == productInfo) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算总价  商品单价*商品数量+之前计算好的总价
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);

            //将订单明细写入数据库
            //填充订单明细数据，下面这句代码要在后两句前面，因为copyProperties方法为把null值也copy过去
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtils.generateUniqueKey());
            orderDetailRepository.save(orderDetail);
        }
        //3.将订单写入数据库
        //填充订单数据
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        //订单状态, 默认为0新下单.
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        //支付状态, 默认为0未支付.
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        //4.扣库存
        List<CartDTO> cartDTOList = orderDetailList
                .stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productInfoService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findOne(orderId);
        if(null==orderMaster){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if(CollectionUtils.isEmpty(orderDetailList)){
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
