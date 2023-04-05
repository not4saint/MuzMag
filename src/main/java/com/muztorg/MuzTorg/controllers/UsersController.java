package com.muztorg.MuzTorg.controllers;

import com.muztorg.MuzTorg.dto.UserInfoDTO;
import com.muztorg.MuzTorg.dto.UserUpdateInfoDTO;
import com.muztorg.MuzTorg.security.exceptions.EmailAlreadyRegisteredException;
import com.muztorg.MuzTorg.services.UserService;
import com.muztorg.MuzTorg.services.UserServiceImpl;
import com.muztorg.MuzTorg.util.UserValidator;
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
    private final UserValidator userValidator;
    @GetMapping("/user-info")
    public UserInfoDTO getUserInfo() {
        return userService.findUserByEmail();
    }

    @PostMapping("/user-info/update")
    public ResponseEntity<HttpStatus> updateUserInfo(@RequestBody UserUpdateInfoDTO userUpdateInfoDTO,
                                                     BindingResult bindingResult) {
        userValidator.validate(userUpdateInfoDTO, bindingResult);
        if (bindingResult.hasErrors())
            throw new EmailAlreadyRegisteredException("This email is already registered");

        userService.updateUserInformation(userUpdateInfoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
