package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.models.Role;
import java.util.Set;



@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {
   private final RoleDao roleDao;
   @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    public Set<Role> getRoles() {
        return roleDao.getRoles();
    }

    public void deleteRole(Long id) {
       roleDao.deleteRole(id);
    }
}
