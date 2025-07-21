package com.nexa.demo.controller;

import com.nexa.demo.UserService;
import com.nexa.demo.dto.LoginDTO;
import com.nexa.demo.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: itpan
 * @Date: 2025/6/29 16:40
 */
@RestController
@Validated
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginDTO loginDTO) {
        User user = userService.login(loginDTO);
    }
}
