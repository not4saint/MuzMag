package com.muztorg.MuzTorg.services.impls;

import com.muztorg.MuzTorg.dto.users.UserInfoDTO;
import com.muztorg.MuzTorg.dto.users.UserUpdateInfoDTO;
import com.muztorg.MuzTorg.models.user.User;
import com.muztorg.MuzTorg.repositories.UsersRepository;
import com.muztorg.MuzTorg.security.exceptions.EmptyUserInformationException;
import com.muztorg.MuzTorg.services.interfaces.AuthenticationService;
import com.muztorg.MuzTorg.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, AuthenticationService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public UserInfoDTO findUserByEmail() {
        Optional<User> optionalUser = usersRepository.findById(getUserAfterAuthenticationInCurrentSession().getId());

        if (optionalUser.isEmpty()) {
            throw new EmptyUserInformationException("Sorry, but server can't send information about account");
        }
        return convertUserToUserDTO(optionalUser.get());
    }

    @Transactional
    public void updateUserInformation(UserUpdateInfoDTO userUpdateInfoDTO) {
        Optional<User> optionalUser = usersRepository.findById(getUserAfterAuthenticationInCurrentSession().getId());

        if (optionalUser.isEmpty()) {
            throw new EmptyUserInformationException("An error occurred with sending user information");
        }

        User user = optionalUser.get();
        if (userUpdateInfoDTO.getFirstname() != null)
            user.setFirstname(userUpdateInfoDTO.getFirstname());
        if (userUpdateInfoDTO.getLastname() != null)
            user.setLastname(userUpdateInfoDTO.getLastname());
        if (userUpdateInfoDTO.getEmail() != null)
            user.setEmail(userUpdateInfoDTO.getEmail());
        if (userUpdateInfoDTO.getPassword() != null)
            user.setPassword(userUpdateInfoDTO.getPassword());
        usersRepository.save(user);
    }
    public Optional<User> checkUniqueByEmailDuringRegistration(String email) {
        return usersRepository.findByEmail(email);
    }

    private UserInfoDTO convertUserToUserDTO(User user) {
        return modelMapper.map(user, UserInfoDTO.class);
    }

    private User convertUserUpdateInfoDTOToUser(UserUpdateInfoDTO userUpdateInfoDTO) {
        return modelMapper.map(userUpdateInfoDTO, User.class);
    }
}
