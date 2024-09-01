package com.xenon.exceptions.enumeration;

import lombok.Getter;

@Getter
public enum ResponseEnum {

    SUCCESS(20000,"请求成功"),
    INVALID_ACCOUNT(40001,"账户名或密码错误"),
    ERROR(-1,"未知错误");

    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 提示信息
     */
    private final String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
