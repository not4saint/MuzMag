package com.muztorg.MuzTorg.controllers;

import com.muztorg.MuzTorg.dto.AuthDTO;
import com.muztorg.MuzTorg.security.exceptions.EmailAlreadyRegisteredException;
import com.muztorg.MuzTorg.services.interfaces.RegistrationService;
import com.muztorg.MuzTorg.util.UserValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/muzmag/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserValidator userValidator;
    private final RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> register(@RequestBody @Valid AuthDTO authDTO, BindingResult bindingResult) {
        userValidator.validate(authDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new EmailAlreadyRegisteredException("This email is already registered");
        }
        registrationService.register(authDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
