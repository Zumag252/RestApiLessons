package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface RoleService {
    void saveRole(List<Role> role);
    Collection<Role> getRoles();
    void deleteRole(Long id);
    Role findByName(String roleName);

}
