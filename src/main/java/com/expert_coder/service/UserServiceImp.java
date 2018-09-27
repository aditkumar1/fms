package com.expert_coder.service;

import com.expert_coder.entity.User;
import com.expert_coder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> find(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
