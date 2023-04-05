package com.muztorg.MuzTorg.services;

import com.muztorg.MuzTorg.dto.UserInfoDTO;
import com.muztorg.MuzTorg.dto.UserUpdateInfoDTO;
import com.muztorg.MuzTorg.models.user.User;

import java.util.Optional;

public interface UserService {
    UserInfoDTO findUserByEmail();
    void updateUserInformation(UserUpdateInfoDTO userUpdateInfoDTO);
    Optional<User> checkUniqueByEmailDuringRegistration(String email);
}
