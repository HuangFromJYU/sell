package edu.jyu.sell.exception;

import edu.jyu.sell.enums.ResultEnum;

/**
 * 自定义异常
 *
 * @author Jason
 * @create 2017-12-09 10:35
 **/
public class SellException extends RuntimeException {
    /**
     * 异常码
     */
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }


    public SellException(ResultEnum resultEnum, String message) {
        super(message);
        this.code = resultEnum.getCode();
    }
}
