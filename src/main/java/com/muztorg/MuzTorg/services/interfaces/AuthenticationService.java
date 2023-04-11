package com.muztorg.MuzTorg.services.interfaces;


import com.muztorg.MuzTorg.models.user.User;
import com.muztorg.MuzTorg.security.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public interface AuthenticationService {
    default User getUserAfterAuthenticationInCurrentSession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUser();
    }
}
