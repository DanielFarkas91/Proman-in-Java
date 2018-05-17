package com.codecool.proman.service;

import com.codecool.proman.model.Users;
import com.codecool.proman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(Users entity) {
        userRepository.save(entity);
    }

    public Users getUserById(int userId) {
        return userRepository.findOne(userId);
    }
}
