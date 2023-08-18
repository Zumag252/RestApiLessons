package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.HashSet;
import java.util.Set;

public interface UserDao {
    Set<User> getAllUsers();
    void createUser(User user);
    User userById(long id);
    void deleteUser(long id);
    User updateUser(long id, User updatedUser);
    User findByUsername(String username);
}
