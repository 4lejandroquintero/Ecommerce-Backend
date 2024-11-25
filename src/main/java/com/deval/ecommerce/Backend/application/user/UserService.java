package com.deval.ecommerce.Backend.application.user;

import com.deval.ecommerce.Backend.domain.model.user.User;
import com.deval.ecommerce.Backend.domain.port.user.IUserRepository;

public class UserService {
    private final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User save (User user) {
        return iUserRepository.save(user);
    }

    public User findById (Integer id) {
        return iUserRepository.findById(id);
    }

    public User findByEmail (String email) {
        return iUserRepository.findByEmail(email);
    }
}
