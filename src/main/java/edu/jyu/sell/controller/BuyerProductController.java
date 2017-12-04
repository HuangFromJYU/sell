package edu.jyu.sell.controller;

import edu.jyu.sell.VO.ProductInfoVO;
import edu.jyu.sell.VO.ProductCategoryVO;
import edu.jyu.sell.VO.ResultVO;
import edu.jyu.sell.entity.ProductCategory;
import edu.jyu.sell.entity.ProductInfo;
import edu.jyu.sell.service.ProductCategoryService;
import edu.jyu.sell.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 买家商品
 *
 * @author Jason
 * @create 2017-12-04 22:10
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        //1. 查询所有上架商品
        List<ProductInfo> productInfos = productInfoService.findUpAll();
        //2. 查询所有上架商品所在的类目类型
        List<Integer> categoryTypes = productInfos.stream()//
                .map(e -> e.getCategoryType())//
                .collect(Collectors.toList());
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryTypes);
        //3. 数据封装
        //=========3.1最外层数据封装=========
        ResultVO resultVO = new ResultVO();
        List<ProductCategoryVO> productCategoryVOList = new ArrayList<>();
        for (ProductCategory category : productCategories) {
            //=========3.2商品类目数据封装=========
            ProductCategoryVO productCategoryVO = new ProductCategoryVO();
            productCategoryVO.setCategoryName(category.getCategoryName());
            productCategoryVO.setCategoryType(category.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo pd : productInfos) {
                //=========3.3商品详情数据封装=========
                if(pd.getCategoryType().equals(category.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(pd,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
                //=========3.3商品详情数据封装=========
            }
            productCategoryVO.setProductInfoVOList(productInfoVOList);
            //=========3.2商品类目数据封装=========
            productCategoryVOList.add(productCategoryVO);
        }
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(productCategoryVOList);
        //=========3.1最外层数据封装=========
        return resultVO;
    }
}
