package com.muztorg.MuzTorg.controllers;

import com.muztorg.MuzTorg.dto.UserInfoDTO;
import com.muztorg.MuzTorg.dto.UserUpdateInfoDTO;
import com.muztorg.MuzTorg.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/muztorg")
public class UsersController {
    private final UserService userService;
    @GetMapping("/user-info")
    public UserInfoDTO getUserInfo() {
        return userService.findUserByEmail();
    }

    @PostMapping("/user-info/update")
    public ResponseEntity<HttpStatus> updateUserInfo(@RequestBody UserUpdateInfoDTO userUpdateInfoDTO,
                                                     BindingResult bindingResult) {
        /// TODO: 29.03.2023 добавить проверку на мыло
        userService.updateUserInformation(userUpdateInfoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
