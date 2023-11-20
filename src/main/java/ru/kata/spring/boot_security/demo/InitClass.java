package ru.kata.spring.boot_security.demo;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class InitClass {

    private final UserService userService;

    public InitClass(UserService userService) {
        this.userService = userService;
    }


    @PostConstruct
    @Transactional
    public void postConstruct() {
        Set<Role> roleAdmin = Set.of(new Role("ROLE_ADMIN"));
        Set<Role> roleUser = Set.of(new Role("ROLE_USER"));

        User admin = new User("admin", "adminov",44, "admin@mail.ru", "admin", roleAdmin);
        User user = new User("user", "userov",35, "user@mail.ru", "user", roleUser);
        User user1 = new User("max","zhuravlev",35,"max@mail.ru","max", roleUser);
        User user2 = new User("anna","grigoryan",30,"anna@mail.ru","anna", roleUser);
        userService.saveUser(admin);
        userService.saveUser(user);
        userService.saveUser(user1);
    }
}