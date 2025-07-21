package com.nexa.demo;

import com.nexa.demo.dto.LoginDTO;
import com.nexa.demo.entity.User;

/**
 * 用户相关服务
 *
 * @Author: nexa
 * @Date: 2025/6/29 19:01
 */
public interface UserService {
    /**
     * 用户登录
     *
     * @param loginDTO 登录参数
     * @return 登录用户信息
     */
    User login(LoginDTO loginDTO);
}
