package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void update(long id, User updatedUser);
    void delete(long id);
    List<User> findAll();
    User findOne(long id);
    public User findByUsername(String username);
}
