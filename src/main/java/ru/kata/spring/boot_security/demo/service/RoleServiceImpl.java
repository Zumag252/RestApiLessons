package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.DAO.RoleDao;
import ru.kata.spring.boot_security.demo.models.Role;

import javax.annotation.PostConstruct;
import java.util.Set;


@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @PostConstruct
    @Transactional
    public void init() {
        roleDao.save(new Role("ROLE_USER"));
        roleDao.save(new Role("ROLE_ADMIN"));
    }

    @Override
    public Set<Role> getRolesList() {
        return roleDao.findAll();
    }

}