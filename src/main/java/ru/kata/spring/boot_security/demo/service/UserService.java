package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> showAllUsers();

    void addUser(User user);

    User getUserById(Long id);

    User getUserByUsername(String username);

    void deleteUser(Long id);

    void editUser(Long id, User updatedUser);
}
