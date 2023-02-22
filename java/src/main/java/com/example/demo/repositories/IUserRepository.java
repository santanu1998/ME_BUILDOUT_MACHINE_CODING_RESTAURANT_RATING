package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.User;

public interface IUserRepository {
    User save(User user);
    boolean existsById(Long id);
    Optional<User> findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
    long count();
    void delete(User user);
}
