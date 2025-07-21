package com.nexa.demo.controller;

import cn.dev33.satoken.stp.StpUtil;
// 更新了 LoginDTO 的导入路径
import com.nexa.demo.UserService;
import com.nexa.demo.dto.LoginDTO;
import com.nexa.demo.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关控制器
 *
 * @Author: nexa
 * @Date: 2025/6/29 16:40
 */
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    /**
     * 用户登录
     *
     * @param loginDTO 登录参数
     * @return 登录结果
     */
    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginDTO loginDTO) {
        log.info("用户登录：{}", loginDTO);
        User user = userService.login(loginDTO);
        if (user != null) {
            StpUtil.login(user.getId());
            return "登录成功";
        }
        return "登录失败";
    }

    @GetMapping("/isLogin")
    public String isLogin() {
        log.info("当前会话是否登录");
        return "当前会话是否登录：" + StpUtil.isLogin();
    }
}