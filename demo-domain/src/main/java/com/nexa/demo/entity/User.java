package com.nexa.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 用户实体类
 *
 * @Author: nexa
 * @Date: 2025/6/29 19:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
