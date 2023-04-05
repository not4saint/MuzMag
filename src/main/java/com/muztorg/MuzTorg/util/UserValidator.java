package com.muztorg.MuzTorg.util;

import com.muztorg.MuzTorg.models.user.User;
import com.muztorg.MuzTorg.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {
    private final UserServiceImpl userService;
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        Optional<User> optionalUser = userService.checkUniqueByEmailDuringRegistration(user.getEmail());

        if (optionalUser.isPresent())
            errors.rejectValue("email", "", "User already registered");
    }
}
