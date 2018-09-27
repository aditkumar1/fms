package com.expert_coder.service;

import com.expert_coder.entity.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> find(String id);
    Optional<User> findByUsername(String username);
}
