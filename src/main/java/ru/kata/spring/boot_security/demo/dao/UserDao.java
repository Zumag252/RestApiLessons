package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.User;


import java.util.List;
import java.util.Set;

public interface UserDao  {
    List<User> findAll();

    void save(User user);

    User findById(Long id);
    User findByUsername(String username);

    void deleteById(Long id);
}
