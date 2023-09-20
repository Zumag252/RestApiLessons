package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import javax.validation.Valid;
import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;
    @Autowired
    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public String getUsers(Model model, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("AllRoles", roleService.getRoles());
        return "admin/users";
    }

    @GetMapping("/userPage")
    public String getUserById(Model model, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "admin/userPage";
    }

    @GetMapping("/new")
    public String newUser(Model model, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("newUser", new User());
        model.addAttribute("AllRoles", roleService.getRoles());
        return "admin/new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/new";
        }
        userService.saveUser(user);
        return "redirect:admin/users";
    }
    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

//    @GetMapping("users/{id}")
//    public String getUpdateEventPage(Model model, @PathVariable("id") long id) {
//        model.addAttribute("oneUser", userService.getUserById(id));
//        model.addAttribute("roles", roleService.getRoles());
//        return "/admin/users";
//    }

    @PatchMapping("users/{id}")
    public String updateEvent(@ModelAttribute("user") @Valid User user,
                              @PathVariable("id") long id,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/edit";
        }
        userService.updateUser(id, user);
        return "redirect:/admin/users";
    }
}