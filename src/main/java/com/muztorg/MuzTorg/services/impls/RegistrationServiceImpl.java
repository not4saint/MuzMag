package com.muztorg.MuzTorg.services.impls;

import com.muztorg.MuzTorg.dto.AuthDTO;
import com.muztorg.MuzTorg.models.user.Role;
import com.muztorg.MuzTorg.models.user.User;
import com.muztorg.MuzTorg.repositories.UsersRepository;
import com.muztorg.MuzTorg.services.interfaces.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(AuthDTO authDTO) {
        User user = User.builder()
                .email(authDTO.getEmail())
                .password(passwordEncoder.encode(authDTO.getPassword()))
                .createdAt(LocalDateTime.now())
                .role(Role.USER)
                .enabled(true)
                .nonLocked(true)
                .build();
        usersRepository.save(user);
    }
}
