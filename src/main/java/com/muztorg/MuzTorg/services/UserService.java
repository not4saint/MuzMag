package com.muztorg.MuzTorg.services;

import com.muztorg.MuzTorg.dto.UserDTO;
import com.muztorg.MuzTorg.models.User;
import com.muztorg.MuzTorg.repositories.UsersRepository;
import com.muztorg.MuzTorg.security.UserDetails;
import com.muztorg.MuzTorg.security.exceptions.EmptyUserInformationException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public UserDTO findUserByEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> optionalUser = usersRepository.findById(userDetails.getUser().getId());

        if (optionalUser.isEmpty()) {
            throw new EmptyUserInformationException("Sorry, but server can't send information about account");
        }
        return convertUserToUserDTO(optionalUser.get());
    }
    public Optional<User> checkUniqueByEmail() {
        /// TODO: 28.03.2023 для регистрации получаем информацию о зарегестрированном мыле
    }

    private UserDTO convertUserToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
