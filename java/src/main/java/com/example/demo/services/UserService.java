package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.User;
import com.example.demo.repositories.IUserRepository;

public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private List<User> users = new ArrayList<>();

    public User registerUser(String name) {
        User user = new User(Long.valueOf(users.size() + 1), name);
        users.add(user);
        User resultantUser = userRepository.save(user);
        return resultantUser;
    }
}
