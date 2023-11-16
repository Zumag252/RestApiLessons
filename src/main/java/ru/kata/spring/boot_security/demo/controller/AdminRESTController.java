package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminRESTController {

    private final UserService userService;

    public AdminRESTController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> showAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> createUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> edit(@RequestBody User user, @PathVariable("id") long id) {
        userService.updateUser(id, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
