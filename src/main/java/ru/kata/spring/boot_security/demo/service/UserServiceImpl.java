package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.models.User;
import java.util.Set;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    @Override
    public void save(User user) {
        userDao.createUser(user);
    }
    @Transactional
    public void update(long id, User updatedUser) {
        userDao.updateUser(id, updatedUser);
    }
    @Transactional
    public void delete(long id) {
        userDao.deleteUser(id);
    }
    public Set<User> findAll() {
        return userDao.getAllUsers();
    }
    public User findOne(long id) {
        return userDao.userById(id);
    }
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

}
