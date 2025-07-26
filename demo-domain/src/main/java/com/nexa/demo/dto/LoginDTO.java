package com.nexa.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 登录参数
 *
 * @Author: Nexa
 * @Date: 2025/6/29 17:05
 */
@Data
@Schema(description = "登录参数")
public class LoginDTO {

    @Schema(description = "用户名", example = "admin", minLength = 3, maxLength = 20)
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Schema(description = "密码", example = "123456", minLength = 6, maxLength = 20)
    @NotBlank(message = "密码不能为空")
    private String password;
}