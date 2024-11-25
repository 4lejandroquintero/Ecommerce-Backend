package com.deval.ecommerce.Backend.infrastructure.adapter.user.impl;

import com.deval.ecommerce.Backend.domain.model.user.User;
import com.deval.ecommerce.Backend.domain.port.user.IUserRepository;
import com.deval.ecommerce.Backend.infrastructure.adapter.user.IUserCrudRepository;
import com.deval.ecommerce.Backend.infrastructure.mapper.user.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserCrudRepositoryImpl implements IUserRepository {

    private final IUserCrudRepository iUserCrudRepository;
    private final UserMapper userMapper;

    public UserCrudRepositoryImpl(IUserCrudRepository iUserCrudRepository, UserMapper userMapper) {
        this.iUserCrudRepository = iUserCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        return userMapper.toUser(iUserCrudRepository.save( userMapper.toUserEntity(user) ));
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return userMapper.toUser( iUserCrudRepository.findById(id).get() );
    }
}
