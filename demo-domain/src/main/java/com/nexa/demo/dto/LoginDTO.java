package com.nexa.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 登录参数
 *
 * @Author: nexa
 * @Date: 2025/6/29 17:05
 */
@Data
public class LoginDTO {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
}