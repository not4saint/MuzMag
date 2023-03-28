package com.muztorg.MuzTorg.controllers;

import com.muztorg.MuzTorg.dto.UserDTO;
import com.muztorg.MuzTorg.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/muztorg")
public class UsersController {
    private final UserService userService;
    @GetMapping("/user-info")
    public UserDTO getUserInfo() {
        return userService.findUserByEmail();
    }
}
