package com.nexa.demo.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 统一返回结果类
 *
 * @Author: Nexa
 * @Date: 2025/7/21 19:45
 */
@Data
@Schema(description = "统一返回结果")
public class Result<T> {
    private static final Integer SUCCESS_CODE = 1;
    private static final String SUCCESS_DEFAULT_MESSAGE = "操作成功";
    private static final Integer FAIL_CODE = 0;
    private static final String FAIL_DEFAULT_MESSAGE = "操作失败";

    
    @Schema(description = "状态码(1为成功,0为失败)", example = "1")
    private Integer code;
    
    @Schema(description = "返回消息", example = "操作成功")
    private String message;
    
    @Schema(description = "返回数据")
    private T data;
    
    @Schema(description = "时间戳", example = "1642665600000")
    private Long timestamp;
    
    public Result() {
        this.timestamp = System.currentTimeMillis();
    }
    
    public Result(Integer code, String message) {
        this();
        this.code = code;
        this.message = message;
    }
    
    public Result(Integer code, String message, T data) {
        this(code, message);
        this.data = data;
    }
    
    /**
     * 成功返回
     */
    public static <T> Result<T> success() {
        return new Result<>(SUCCESS_CODE, SUCCESS_DEFAULT_MESSAGE);
    }
    
    /**
     * 成功返回带数据
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS_CODE, SUCCESS_DEFAULT_MESSAGE, data);
    }
    
    /**
     * 成功返回带消息和数据
     */
    public static <T> Result<T> success(String message, T data) {
        return new Result<>(SUCCESS_CODE, message, data);
    }
    
    /**
     * 失败返回
     */
    public static <T> Result<T> error() {
        return new Result<>(FAIL_CODE, FAIL_DEFAULT_MESSAGE);

    }
    
    /**
     * 失败返回带消息
     */
    public static <T> Result<T> error(String message) {
        return new Result<>(FAIL_CODE, message);
    }
}
