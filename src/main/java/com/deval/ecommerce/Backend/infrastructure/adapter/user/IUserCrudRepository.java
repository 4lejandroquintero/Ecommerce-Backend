package com.deval.ecommerce.Backend.infrastructure.adapter.user;

import com.deval.ecommerce.Backend.infrastructure.entity.user.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserCrudRepository extends CrudRepository<UserEntity,Integer> {
    Optional<UserEntity> findByEmail(String email);
}
