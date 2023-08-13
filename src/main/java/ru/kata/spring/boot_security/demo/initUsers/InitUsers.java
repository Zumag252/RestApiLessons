//package ru.kata.spring.boot_security.demo.initUsers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import ru.kata.spring.boot_security.demo.models.Role;
//import ru.kata.spring.boot_security.demo.models.User;
//import ru.kata.spring.boot_security.demo.service.RoleService;
//import ru.kata.spring.boot_security.demo.service.UserService;
//import javax.transaction.Transactional;
//import java.util.*;
//
//
//@Component
//public class InitUsers {
//    private final RoleService roleService;
//    private final UserService userService;
//
//    final Role role_admin = new Role("ROLE_ADMIN");
//    final Role role_user = new Role("ROLE_USER");
//
//    @Autowired
//    public InitUsers(RoleService roleService, UserService userService) {
//        this.roleService = roleService;
//        this.userService = userService;
//    }
//
//    public Set<Role> roleAdmin() {
//        Set<Role> roles = new HashSet<>();
//        roles.add(role_admin);
//        return roles;
//    }
//
//    public Set<Role> roleUser() {
//        Set<Role> roles = new HashSet<>();
//        roles.add(role_user);
//        return roles;
//    }
//    @Transactional
//    @Bean
//    public void init() {
//        roleService.saveRole(role_admin);
//        roleService.saveRole(role_user);
//        userService.save(new User("admin", 35, "admin@mail", "admin", roleAdmin()));
//        userService.save(new User("user", 30, "user@mail.ru", "user", roleUser()));
//    }
//}
