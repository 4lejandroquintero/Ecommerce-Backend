package com.deval.ecommerce.Backend.application.security;

import com.deval.ecommerce.Backend.domain.model.user.User;
import com.deval.ecommerce.Backend.domain.port.user.IUserRepository;

public class RegistrationService {
    private final IUserRepository iUserRepository;

    public RegistrationService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User register (User user){
        return iUserRepository.save(user);
    }
}
