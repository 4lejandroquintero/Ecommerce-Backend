package com.deval.ecommerce.Backend.infrastructure.service;

import com.deval.ecommerce.Backend.application.user.UserService;
import com.deval.ecommerce.Backend.domain.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomUserDetailService implements UserDetailsService {
    private UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername: {}", username);
        User user = userService.findByEmail(username);
        return org.springframework.security.core.userdetails.User.builder().username(user.getEmail())
                .password(user.getPassword()).roles(user.getUserType().name()).build();
    }
}
