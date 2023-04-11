package com.muztorg.MuzTorg.services.impls;

import com.muztorg.MuzTorg.models.user.User;
import com.muztorg.MuzTorg.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = usersRepository.findByEmail(email);

        if (optionalUser.isEmpty())
            throw new UsernameNotFoundException(String.format("User not found with email: %s", email));
        return new com.muztorg.MuzTorg.security.UserDetails(optionalUser.get());
    }
}
