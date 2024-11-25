package com.deval.ecommerce.Backend.domain.port.user;

import com.deval.ecommerce.Backend.domain.model.user.User;

public interface IUserRepository {
    User save(User user);
    User findByEmail(String email);
    User findById(Integer id);
}
