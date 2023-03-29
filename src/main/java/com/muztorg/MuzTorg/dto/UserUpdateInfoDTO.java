package com.muztorg.MuzTorg.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateInfoDTO {
    private String firstname;
    private String lastname;
    @Email
    private String email;
    private String password;
}
