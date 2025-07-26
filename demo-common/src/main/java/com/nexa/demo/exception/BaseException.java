package com.nexa.demo.exception;

/**
 * 基础业务异常类
 *
 * @Author: Nexa
 * @Date: 2025/7/26 17:02
 */
public class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }
}
