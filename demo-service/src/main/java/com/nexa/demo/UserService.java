package com.nexa.demo;

import com.nexa.demo.dto.LoginDTO;
import com.nexa.demo.entity.User;
import jakarta.validation.Valid;

/**
 * 登录服务
 *
 * @Author: itpan
 * @Date: 2025/6/29 19:01
 */
public interface LoginService {
    User login(LoginDTO loginDTO);
}
