package edu.jyu.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商品类目
 *
 * @author Jason
 * @create 2017-12-02 11:24
 **/
//该注解可以自动使此类映射数据库表product_category，如果类名与表名不一致，可以使用@Table(name = "tbl_product_category")进行映射
@Entity()
//注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法。
// 在编译的时候就生成了，所以不用运行时考虑效率问题。
@Data
//@DynamicUpdate属性:设置为true,设置为true,表示update对象的时候,生成动态的update语句,如果这个字段的值是null就不会被加入到update语句中,默认false。
//比如只想更新某个属性，但是却把整个对象的属性都更新了，这并不是我们希望的结果，我们希望的结果是：我更改了哪些字段，只要更新我修改的字段就够了。
@DynamicUpdate
public class ProductCategory {
    /**
     * 类目id.
     */
    @Id
    @GeneratedValue
    private Integer categoryId;


    /**
     * 类目名字. 对应表product_category中的category_name，如果列名和属性名不一致可用 @Column("")进行映射
     */
    private String categoryName;

    /**
     * 类目编号.
     */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
