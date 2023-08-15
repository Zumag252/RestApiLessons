package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/adminPage")
    public String getAdminPage() {
        return "admin/adminPage";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "admin/userPage";
    }

    @GetMapping("/new")
    public String newUser(Model model, User user) {
        model.addAttribute("user", new User());
        return "admin/new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:admin/users";
    }

}