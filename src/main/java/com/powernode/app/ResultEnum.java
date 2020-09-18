package com.powernode.app;

/**
 * Company : BJPowernode
 * Date : 2020/9/15
 * Description :
 */
public enum  ResultEnum {

    PARAM_NODE_FOUND(404,"参数异常"),
    NOT_FOUND(404,"为找打破");

    ResultEnum(int code,String message){

        this.code =code;
        this.message = message;

    }

    private int code;

    private String message;





}
