package com.nexa.demo.impl;

import com.nexa.demo.UserService;
import com.nexa.demo.dto.LoginDTO;
import com.nexa.demo.entity.User;
import com.nexa.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户相关实现类
 *
 * @Author: nexa
 * @Date: 2025/6/29 19:01
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;
    /**
     * 用户登录
     *
     * @param loginDTO 登录参数
     * @return 登录用户信息
     */
    @Override
    public User login(LoginDTO loginDTO) {
        return userMapper.selectByUsername(loginDTO.getUsername());
    }
}
