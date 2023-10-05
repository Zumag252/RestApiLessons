package ru.kata.spring.boot_security.demo.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class AdminRestController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public AdminRestController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers().stream().map(this::convertToUserDTO).collect(Collectors.toList());
    }

    @GetMapping("/users/{id}")
    public UserDTO getUserByID (@PathVariable long id) {
        return convertToUserDTO(userService.getUserById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<HttpStatus> createNewUser (@RequestBody @Valid User newUser) {
        userService.saveUser(newUser);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<HttpStatus> updateUser (@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserByID(@PathVariable long id) {
        if(userService.getUserById(id) == null) {
            throw new NullPointerException("User с таким ID не существует");
        }
        else {
        userService.deleteUser(id);
        }
        return "User c ID " + id + " удален";
    }



    private User convertToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    private UserDTO convertToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
