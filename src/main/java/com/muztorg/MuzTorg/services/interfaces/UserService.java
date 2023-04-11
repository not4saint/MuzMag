package com.muztorg.MuzTorg.services.interfaces;

import com.muztorg.MuzTorg.dto.users.UserInfoDTO;
import com.muztorg.MuzTorg.dto.users.UserUpdateInfoDTO;
import com.muztorg.MuzTorg.models.user.User;

import java.util.Optional;

public interface UserService {
    UserInfoDTO findUserByEmail();
    void updateUserInformation(UserUpdateInfoDTO userUpdateInfoDTO);
    Optional<User> checkUniqueByEmailDuringRegistration(String email);
}
