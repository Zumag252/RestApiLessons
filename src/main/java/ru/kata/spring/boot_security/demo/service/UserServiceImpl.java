package ru.kata.spring.boot_security.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Set;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }
    @Override
    public List<User> showAllUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));

        userDao.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    @Override
    @Transactional
    public void editUser(Long id, User updatedUser) {
        User user = userDao.findById(id);
        user.setId(updatedUser.getId());
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setRoles(updatedUser.getRoles());
        if (!user.getPassword().equals(updatedUser.getPassword())) {
            user.setPassword(encoder.encode(updatedUser.getPassword()));
            userDao.save(user);
        }
    }
}
