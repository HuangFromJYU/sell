package edu.jyu.sell.vo;

import lombok.Data;

/**
 * http请求返回的最外层对象
 *
 * @author Jason
 * @create 2017-12-04 22:13
 **/
@Data
public class ResultVO<T> {
    /**
     * 错误码.
     */
    private Integer code;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 具体内容.
     */
    private T data;
}
