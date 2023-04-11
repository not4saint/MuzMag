package com.muztorg.MuzTorg.services.interfaces;

import com.muztorg.MuzTorg.dto.AuthDTO;
import com.muztorg.MuzTorg.models.user.User;

public interface RegistrationService {
    void register(AuthDTO authDTO);
}
