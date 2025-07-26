package com.nexa.demo.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.nexa.demo.UserService;
import com.nexa.demo.result.Result;
import com.nexa.demo.dto.LoginDTO;
import com.nexa.demo.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关控制器
 *
 * @Author: Nexa
 * @Date: 2025/6/29 16:40
 */
@Tag(name = "用户管理")
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Result<String> login(@RequestBody @Valid LoginDTO loginDTO) {
        log.info("用户登录：{}", loginDTO);
        User user = userService.login(loginDTO);
        if (user != null) {
            StpUtil.login(user.getId());
            return Result.success("登录成功", StpUtil.getTokenValue());
        }
        return Result.error("登录失败，用户名或密码错误");
    }

    @Operation(summary = "检查登录状态")
    @GetMapping("/isLogin")
    public Result<Boolean> isLogin() {
        log.info("当前会话是否登录");
        boolean isLogin = StpUtil.isLogin();
        return Result.success("查询成功", isLogin);
    }

    @Operation(summary = "用户退出登录")
    @PostMapping("/logout")
    public Result<String> logout() {
        log.info("用户退出登录");
        StpUtil.logout();
        return Result.success("退出登录成功");
    }

}